package eventmaker.repository.shared;

import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.data.exceptions.NotRegisteredRepositoryException;
import eventmaker.data.shared.Entity;
import java.util.List;

public interface IRepository<T extends Entity> {
    T get(final Object identifier) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException;
    List<T> getList() throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException;
    void remove(final T entity) throws RepositoryException, NotRegisteredRepositoryException, DifferentObjectInIdentityMapException;
    void store(final T entity) throws RepositoryException, DifferentObjectInIdentityMapException;
    void storeBatch(T... entities) throws RepositoryException, DifferentObjectInIdentityMapException;
}