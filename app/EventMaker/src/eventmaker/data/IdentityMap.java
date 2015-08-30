/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.data;

import eventmaker.data.Entity;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.Validate;

/**
 *
 * @author dsvma_000
 */
public final class IdentityMap<T extends Entity> {
    private final Map<Object, T> map = new HashMap<Object, T>();
    
    public T get(final Object identifier) {
        Validate.notNull(identifier, "identifier required");
        return map.get(identifier);
    }
    
    public void register(final T entity) throws DifferentObjectInIdentityMap {
        Validate.notNull(entity, "entity required");
        if (!isKnown(entity)) map.put(entity.getIdentifier(), entity);
    }
    
    public void forget(final T entity) 
            throws NotRegisterdRepositoryException, DifferentObjectInIdentityMap {
        Validate.notNull(entity, "entity required");
        if (!isKnown(entity)) throw new NotRegisterdRepositoryException(entity);
        map.remove(entity.getIdentifier());
    }
    
    public boolean isKnown(final T entity) throws DifferentObjectInIdentityMap {
        Validate.notNull(entity, "entity required");
        
        Object identifier = entity.getIdentifier();
        T entityInMap = map.get(identifier);
        if (entityInMap != null && entityInMap != entity)
            throw new DifferentObjectInIdentityMap(identifier, entity, entityInMap);
        
        return entityInMap != null;
    }
}
