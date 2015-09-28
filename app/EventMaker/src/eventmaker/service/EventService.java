package eventmaker.service;

import eventmaker.data.Event;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.logic.managers.EventManager;
import eventmaker.repository.exceptions.RepositoryException;
import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

public class EventService {
    EventManager _evManager = new EventManager();
    
    public Event create(String name, Integer categoryId, Date eventDate,
            String description, ApproveRule approveRule,
            PaymentRule paymentRule, Availability availability,
            BigDecimal cost, Integer companyId) throws RepositoryException {
        
        return _evManager.create(name, categoryId, eventDate, description, approveRule, paymentRule, availability, cost, companyId);
    }
    
    public Event get(Integer id) throws RepositoryException {
        return _evManager.get(id);
    }
    
    public List<Event> getList() throws RepositoryException {
        return _evManager.getList();
    }

    public List<Event> getListByCompany(Integer id) throws RepositoryException {
        return _evManager.getListByCompany(id);
    }

    public List<Event> getListOpened() {
        return _evManager.getListOpened();
    }

}
