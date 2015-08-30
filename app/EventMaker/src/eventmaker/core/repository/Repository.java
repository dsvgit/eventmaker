/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.core.repository;

import eventmaker.data.Entity;
import eventmaker.data.IdentityMap;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author dsvma_000
 */
public class Repository<T extends Entity> {
    protected final IdentityMap<T> identityMap = new IdentityMap<T>();
    
    public T get(final Object identifier) throws RepositoryException {
        Validate.notNull(identifier, "identifier required");
        
        T entity = identityMap.get(identifier);
        
        if (entity == null) {
            entity = select(identifier);
            if (entity == null) throw new NotFoundException(identifier);
            
            assert entity.getIdentifier() == identifier : "select something different";
            
            identityMap.register(entity);
        }
        
        return entity;
    }
    
    public void store(final T entity) throws RepositoryException {
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
    
    public void remove(final T entity) throws RepositoryException {
        Validate.notNull(entity, "entity required");
        
        identityMap.forget(entity);
        delete(entity);
    }
}
