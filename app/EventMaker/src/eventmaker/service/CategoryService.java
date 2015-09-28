package eventmaker.service;

import eventmaker.data.Category;
import eventmaker.logic.managers.CategoryManager;
import eventmaker.repository.exceptions.RepositoryException;
import java.util.List;

public class CategoryService {
    CategoryManager _catManager = new CategoryManager();
    
    public Category create(String name) throws RepositoryException {
        return _catManager.create(name);
    }
    
    public Category get(Integer id) throws RepositoryException {
        return _catManager.get(id);
    }
    
    public List<Category> getList() throws RepositoryException {
        return _catManager.getList();
    }
}
