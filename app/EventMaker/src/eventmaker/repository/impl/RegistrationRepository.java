package eventmaker.repository.impl;

import eventmaker.repository.IRegistrationRepository;
import eventmaker.repository.shared.Repository;
import eventmaker.data.Event;
import eventmaker.data.Registration;
import eventmaker.data.User;
import eventmaker.data.enums.PaymentState;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class RegistrationRepository extends Repository<Registration, Integer> implements IRegistrationRepository {

    @Override
    public List<Registration> getByEvent(Event event) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Registration> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("event.id", event.getIdentifier()))
                .list();
        tr.commit();
        session.close();
        
        return list;
    }
    
    @Override
    protected Class<Registration> getDomainClass() {
        return Registration.class;
    }

    @Override
    public List<Registration> getByUser(User user) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Registration> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("user.id", user.getIdentifier()))
                .list();
        tr.commit();
        session.close();
        
        return list;
    }

    @Override
    public Registration getByUserAndEvent(User user, Integer eventId) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Registration> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("user.id", user.getIdentifier()))
                .add(Restrictions.eq("event.id", eventId))
                .list();
        Registration reg = !list.isEmpty() ? list.iterator().next() : null;
        tr.commit();
        session.close();
        
        return reg;
    }    

    @Override
    public List<Registration> getToAdminConfirmation() {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Registration> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("paymentState", PaymentState.ON_ADMIN_CONFIRMATION))
                .list();
        tr.commit();
        session.close();
        
        return list;
    }
}
