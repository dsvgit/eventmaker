package eventmaker.repository.impl;

import eventmaker.repository.shared.Repository;
import eventmaker.data.Category;
import eventmaker.repository.ICategoryRepository;

public class CategoryRepository extends Repository<Category, Integer> implements ICategoryRepository {

    @Override
    protected Class<Category> getDomainClass() {
        return Category.class;
    }
    
}
