package eventmaker.data.exceptions;

import eventmaker.data.shared.Entity;

public class NotRegisteredRepositoryException extends Throwable{
    public NotRegisteredRepositoryException(Entity entity) {
        super("this entity " + entity + " non registered");
    }
}
