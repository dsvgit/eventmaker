package eventmaker.repository.impl;

import eventmaker.repository.shared.Repository;
import eventmaker.data.User;
import eventmaker.repository.IUserRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UserRepository extends Repository<User, Integer> implements IUserRepository {

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<User> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("login", login))
                .list();
        User user = !list.isEmpty() ? list.iterator().next() : null;
        tr.commit();
        session.close();
        
        return user;
    }
}
