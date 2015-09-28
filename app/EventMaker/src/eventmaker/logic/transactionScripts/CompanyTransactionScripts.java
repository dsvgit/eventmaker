/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.transactionScripts;

import eventmaker.dao.CompanyDAO;
import eventmaker.data.Company;
import eventmaker.data.User;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.models.CompanyMapper;
import eventmaker.logic.models.VCompany;
import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.service.CompanyService;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dsvma_000
 */
public class CompanyTransactionScripts {
    private final ICompanyRepository _compRep = new CompanyDAO();
    private final IIdentity _identity = Identity.getInstance();
    private final CompanyMapper _mapper = new CompanyMapper();
    
    public Company create(String name, String description) throws RepositoryException {
        Company cmp;
        try {
            cmp = new Company(name, description, (User) _identity.getUser());
        } catch (UserAuthorizationException ex) {
            Logger.getLogger(CompanyService.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException();
        }
        _compRep.store(cmp);
        
        return cmp;
    }
    
    public Company get(final Integer id) throws RepositoryException {
        return _compRep.get(id);
    }
    
    public List<VCompany> getList() throws RepositoryException {
        List<VCompany> vList = new LinkedList<>();
        List<Company> list = _compRep.getList();
        for (Company c : list) {
            vList.add(_mapper.Map(c));
        }
        return vList;
    }
    
    public void delete(Integer id) throws RepositoryException {
        Company cmp = _compRep.get(id);
        _compRep.remove(cmp);
    }

    public List<VCompany> getListCurrent() throws RepositoryException, UserAuthorizationException {
        List<VCompany> vList = new LinkedList<>();
        List<Company> list = _compRep.getListCurrent(_identity.getUser());
        for (Company c : list) {
            vList.add(_mapper.Map(c));
        }
        return vList;
    }
}
