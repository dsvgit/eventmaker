package eventmaker.repository.shared;

import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.data.shared.Entity;
import eventmaker.data.shared.IdentityMap;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.data.exceptions.NotRegisteredRepositoryException;
import java.io.Serializable;
import java.util.List;
import org.apache.commons.lang3.Validate;

public abstract class Repository<T extends Entity, ID extends Serializable> extends RepositoryBase<T, ID> implements IRepository<T> {
    protected final IdentityMap<T> identityMap = new IdentityMap<>();
    
    @Override
    public List<T> getList() throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return list();
    }
    
    @Override
    public T get(final Object identifier) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        Validate.notNull(identifier, "identifier required");
        
        T entity = identityMap.get(identifier);
        
        if (entity == null) {
            entity = select((ID)identifier);
            if (entity == null) throw new NotFoundException(identifier);
            
            assert entity.getIdentifier() == identifier : "select something different";
            
            identityMap.register(entity);
        }
        
        return entity;
    }
    
    @Override
    public void storeBatch(T... entities) throws RepositoryException, DifferentObjectInIdentityMapException {
        insertBatch(entities);
    }
    
    @Override
    public void store(final T entity) throws RepositoryException, DifferentObjectInIdentityMapException {
        Validate.notNull(entity, "entity required");
        
        if (identityMap.isKnown(entity)) {
            Object oldIdentifier = entity.getIdentifier();
            update(entity);
            assert oldIdentifier.equals(entity.getIdentifier()) : "identificator can't be modified";
        } else {
            insert(entity);
            identityMap.register(entity);
        }
    }
    
    @Override
    public void remove(final T entity) throws RepositoryException, NotRegisteredRepositoryException, DifferentObjectInIdentityMapException {
        Validate.notNull(entity, "entity required");
        
        identityMap.forget(entity);
        delete(entity);
    }
}