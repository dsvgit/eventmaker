package eventmaker.repository.shared;

import eventmaker.data.shared.Entity;
import eventmaker.hibernate.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class RepositoryBase<T extends Entity, ID extends Serializable> {
    
    protected Class<T> domainClass = getDomainClass();
    protected SessionFactory sessFact;
    
    protected abstract Class<T> getDomainClass();

    protected RepositoryBase() {
        sessFact = HibernateUtil.getSessionFactory();
    }
    
    protected List<T> list() {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<T> list = session.createCriteria(domainClass).list();
        tr.commit();
        session.close();
        
        return list;
    }
    
    protected T select(ID identifier) {
        Session session = sessFact.openSession();
        T entity = (T)session.get(domainClass, identifier);
        session.close();
        
        return entity;
    }
    
    protected void update(T entity) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        session.update(entity);
        tr.commit();
        session.close();
    }
    
    protected void insert(T entity) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        session.save(entity);
        tr.commit();
        session.close();
    }
    
    protected void insertBatch(T... entities) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        int i = 1;
        for (T e : entities) {
            session.save(e);
            if ( i % 20 == 0 ) {
                session.flush();
                session.clear();
            }
            i++;
        }
        tr.commit();
        session.close();
    }
    
    protected void delete(T entity) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        session.delete(entity);
        tr.commit();
        session.close();
    }
}
