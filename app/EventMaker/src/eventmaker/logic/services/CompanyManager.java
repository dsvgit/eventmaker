package eventmaker.logic.services;

import eventmaker.repository.impl.CompanyRepository;
import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
import eventmaker.data.User;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;

public class CompanyManager {
    private final ICompanyRepository _compRep = new CompanyRepository();
    private final IIdentity _identity = new Identity();
    
    public Company create(String name, String description) throws RepositoryException, DifferentObjectInIdentityMapException {
        Company cmp = new Company(name, description, (User) _identity.getUser());
        _compRep.store(cmp);
        
        return cmp;
    }
    
    public Company get(final Integer id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return _compRep.get(id);
    }
}