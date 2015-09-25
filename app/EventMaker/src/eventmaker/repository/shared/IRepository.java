package eventmaker.repository.shared;

import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.shared.Entity;

import java.util.List;

public interface IRepository<T extends Entity> {
    T get(final Object identifier) throws RepositoryException;
    List<T> getList() throws RepositoryException;
    void remove(final T entity) throws RepositoryException;
    void store(final T entity) throws RepositoryException;
    void storeBatch(T... entities) throws RepositoryException;
}