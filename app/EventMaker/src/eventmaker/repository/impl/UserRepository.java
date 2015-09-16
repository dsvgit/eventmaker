package eventmaker.repository.impl;

import eventmaker.data.Registration;
import eventmaker.repository.shared.Repository;
import eventmaker.data.User;
import eventmaker.repository.IUserRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class UserRepository extends Repository<User, Integer> implements IUserRepository {

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

    @Override
    public User getUserByName(String name) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<User> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("name", name))
                .setProjection(Projections.min("id"))
                .list();
        User user = list.size() > 0 ? list.get(0) : null;
        tr.commit();
        session.close();
        
        return user;
    }
}
