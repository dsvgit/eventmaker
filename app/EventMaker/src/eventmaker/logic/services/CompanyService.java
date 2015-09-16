package eventmaker.logic.services;

import eventmaker.repository.impl.CompanyRepository;
import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
import eventmaker.data.Organizer;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.IdentityOrganizer;

public class CompanyService {
    private final ICompanyRepository _compRep = new CompanyRepository();
    private final IIdentity _identity = new IdentityOrganizer();
    
    public Company createCompany(String name, String description) throws RepositoryException, DifferentObjectInIdentityMapException {
        Company cmp = new Company(name, description, (Organizer) _identity.getUser());
        _compRep.store(cmp);
        
        return cmp;
    }
    
    public Company get(final String id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        _compRep.get(id);
        return new Company();
    }
}