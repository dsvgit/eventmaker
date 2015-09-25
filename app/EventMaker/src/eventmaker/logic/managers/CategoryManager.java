package eventmaker.logic.managers;

import eventmaker.data.Category;
import eventmaker.repository.ICategoryRepository;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.CategoryRepository;
import java.util.List;

public class CategoryManager {
    private final ICategoryRepository _catRep = new CategoryRepository();
    
    public Category create(String name) throws RepositoryException {
        Category category = new Category(name);
        _catRep.store(category);
        return category;
    }
    
    public Category get(Integer id) throws RepositoryException {
        return _catRep.get(id);
    }
    
    public List<Category> getList() throws RepositoryException {
        return _catRep.getList();
    }
}
