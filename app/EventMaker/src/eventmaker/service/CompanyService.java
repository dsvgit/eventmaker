package eventmaker.service;

import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.managers.CompanyManager;
import eventmaker.logic.models.VCompany;

import java.util.List;

public class CompanyService {
    CompanyManager _compManager = new CompanyManager();
    
    public Company create(String name, String description) throws RepositoryException {
        return _compManager.create(name, description);
    }
    
    public Company get(final Integer id) throws RepositoryException {
        return _compManager.get(id);
    }
    
    public List<VCompany> getList() throws RepositoryException {
        return _compManager.getList();
    }
    
    public void delete(Integer id) throws RepositoryException {
        _compManager.delete(id);
    }

    public List<VCompany> getListCurrent() throws RepositoryException, UserAuthorizationException {
        return _compManager.getListCurrent();
    }
}