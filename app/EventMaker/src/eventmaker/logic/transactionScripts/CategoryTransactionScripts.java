/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.transactionScripts;

import eventmaker.data.Category;
import eventmaker.repository.ICategoryRepository;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.CategoryRepository;
import java.util.List;

/**
 *
 * @author dsvma_000
 */
public class CategoryTransactionScripts {
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
