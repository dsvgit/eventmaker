package eventmaker.core.repository;

import eventmaker.core.repository.shared.Repository;
import eventmaker.data.Category;

public class CategoryRepository extends Repository<Category, Integer> {

    @Override
    protected Class<Category> getDomainClass() {
        return Category.class;
    }
    
}
