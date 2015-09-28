package eventmaker.repository.impl;

import eventmaker.data.Company;
import eventmaker.repository.shared.Repository;
import eventmaker.data.Event;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.repository.IEventRepository;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class EventRepository extends Repository<Event, Integer> implements IEventRepository{
    
    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }

    @Override
    public List<Event> getListByCompany(Company cmp) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Event> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("company.id", cmp.getIdentifier()))
                .list();
        tr.commit();
        session.close();
        
        return list;
    }

    @Override
    public List<Event> getListOpened() {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Event> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("availability", Availability.OPENED))
                .list();
        tr.commit();
        session.close();
        
        return list;
    }
    
}
