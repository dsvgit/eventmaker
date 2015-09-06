package eventmaker.data.shared;

import java.io.Serializable;

public abstract class ValueObject implements Serializable {
    @Override
    public abstract boolean equals(final Object object);
    
    @Override
    public abstract int hashCode();
    
    @Override
    public abstract String toString();
}
