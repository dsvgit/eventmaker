package eventmaker.repository.shared;

import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.shared.Entity;
import eventmaker.data.shared.IdentityMap;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.data.exceptions.NotRegisteredRepositoryException;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang3.Validate;

public abstract class Repository<T extends Entity, ID extends Serializable> extends RepositoryBase<T, ID> implements IRepository<T> {
    protected final IdentityMap<T> identityMap = new IdentityMap<>();
    
    @Override
    public List<T> getList() throws RepositoryException {
        return list();
    }
    
    @Override
    public T get(final Object identifier) throws RepositoryException {
        Validate.notNull(identifier, "identifier required");
        
        T entity = identityMap.get(identifier);
        
        if (entity == null) {
            entity = select((ID)identifier);
            if (entity == null) throw new RepositoryException();
            
            assert entity.getIdentifier() == identifier : "select something different";
            
            try {
                identityMap.register(entity);
            } catch (DifferentObjectInIdentityMapException ex) {
                Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return entity;
    }
    
    @Override
    public void storeBatch(T... entities) throws RepositoryException {
        insertBatch(entities);
    }
    
    @Override
    public void store(final T entity) throws RepositoryException {
        Validate.notNull(entity, "entity required");
        
        try {
            if (identityMap.isKnown(entity)) {
                Object oldIdentifier = entity.getIdentifier();
                update(entity);
                assert oldIdentifier.equals(entity.getIdentifier()) : "identificator can't be modified";
            } else {
                insert(entity);
                identityMap.register(entity);
            }
        } catch (DifferentObjectInIdentityMapException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException();
        }
    }
    
    @Override
    public void remove(final T entity) throws RepositoryException {
        Validate.notNull(entity, "entity required");
        
        try {
            identityMap.forget(entity);
        } catch (NotRegisteredRepositoryException | DifferentObjectInIdentityMapException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException();
        }
        delete(entity);
    }
}
