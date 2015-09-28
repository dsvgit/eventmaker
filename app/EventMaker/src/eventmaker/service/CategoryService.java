package eventmaker.service;

import eventmaker.data.Category;
import eventmaker.logic.transactionScripts.CategoryTransactionScripts;
import eventmaker.repository.exceptions.RepositoryException;
import java.util.List;

public class CategoryService {
    CategoryTransactionScripts _catManager = new CategoryTransactionScripts();
    
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
