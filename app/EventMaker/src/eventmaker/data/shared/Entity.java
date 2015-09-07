/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.data.shared;

/**
 *
 * @author dsvma_000
 */
public abstract class Entity {    
    public abstract Object getIdentifier();

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        final Entity entity = (Entity)obj;
        return getIdentifier().equals(entity.getIdentifier());
    }

    @Override
    public int hashCode() {
        return getIdentifier().hashCode();
    }    
}
