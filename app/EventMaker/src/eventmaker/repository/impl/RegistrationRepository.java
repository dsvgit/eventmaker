package eventmaker.repository.impl;

import eventmaker.repository.IRegistrationRepository;
import eventmaker.repository.shared.Repository;
import eventmaker.data.Event;
import eventmaker.data.Registration;
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
    
}
