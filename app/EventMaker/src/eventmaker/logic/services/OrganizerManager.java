package eventmaker.logic.services;

import eventmaker.data.Category;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.repository.ICategoryRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.CategoryRepository;

public class OrganizerManager {
    private final ICategoryRepository _catRep = new CategoryRepository();
    
    public Category create(String name) throws RepositoryException, DifferentObjectInIdentityMapException {
        Category category = new Category(name);
        _catRep.store(category);
        return category;
    }
    
    public Category get(Integer id) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
        return _catRep.get(id);
    }
}
