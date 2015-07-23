/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author dsv_admin
 */
public abstract class Entity {
    abstract Object getIdentifier();
    
    @Override
    public boolean equals(final Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        
        final Entity entity = (Entity) object;
        return getIdentifier().equals(entity.getIdentifier());
    }
    
    @Override
    public int hashCode() {
        return getIdentifier().hashCode();
    }
}
