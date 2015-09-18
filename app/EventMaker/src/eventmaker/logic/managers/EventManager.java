package eventmaker.logic.managers;

import eventmaker.data.Category;
import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.logic.models.VCompany;
import eventmaker.repository.IEventRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.EventRepository;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class EventManager {
    private final IEventRepository _eventRep = new EventRepository();
    
    private final CompanyManager _compManager = new CompanyManager();
    private final CategoryManager _catManager = new CategoryManager();
    
    public Event create(String name, Integer categoryId, Date eventDate,
            String description, ApproveRule approveRule,
            PaymentRule paymentRule, Availability availability,
            BigDecimal cost, Integer companyId) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
        
        Category category = _catManager.get(categoryId);
        Company company = _compManager.get(companyId);
        
        Event event = new Event(
                name, 
                category, 
                eventDate, 
                description, 
                approveRule, 
                paymentRule, 
                availability, 
                cost, 
                company
        );

        _eventRep.store(event);
        
        return event;
    }
    
    public Event get(Integer id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return _eventRep.get(id);
    }
    
    public List<Event> getList() throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return _eventRep.getList();
    }

    public List<Event> getListByCompany(Integer id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        Company cmp = _compManager.get(id);
        return _eventRep.getListByCompany(cmp);
    }
}
