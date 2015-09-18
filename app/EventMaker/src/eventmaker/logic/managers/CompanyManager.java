package eventmaker.logic.managers;

import eventmaker.repository.impl.CompanyRepository;
import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
import eventmaker.data.User;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.data.exceptions.NotRegisteredRepositoryException;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.models.CompanyMapper;
import eventmaker.logic.models.VCompany;
import java.util.LinkedList;
import java.util.List;

public class CompanyManager {
    private final ICompanyRepository _compRep = new CompanyRepository();
    private final IIdentity _identity = Identity.getInstance();
    private final CompanyMapper _mapper = new CompanyMapper();
    
    public Company create(String name, String description) throws RepositoryException, DifferentObjectInIdentityMapException, UserAuthorizationException {
        Company cmp = new Company(name, description, (User) _identity.getUser());
        _compRep.store(cmp);
        
        return cmp;
    }
    
    public Company get(final Integer id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return _compRep.get(id);
    }
    
    public List<VCompany> getList() throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        List<VCompany> vList = new LinkedList<>();
        List<Company> list = _compRep.getList();
        for (Company c : list) {
            vList.add(_mapper.Map(c));
        }
        return vList;
    }
    
    public void delete(Integer id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException, NotRegisteredRepositoryException {
        Company cmp = _compRep.get(id);
        _compRep.remove(cmp);
    }
}