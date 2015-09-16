package eventmaker.logic.services;

import eventmaker.data.Category;
import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.repository.ICategoryRepository;
import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.IEventRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.CategoryRepository;
import eventmaker.repository.impl.CompanyRepository;
import eventmaker.repository.impl.EventRepository;
import java.math.BigDecimal;
import java.util.Date;

public class EventService {
    private final ICompanyRepository _compRep = new CompanyRepository();
    private final IEventRepository _eventRep = new EventRepository();
    private final ICategoryRepository _catRep = new CategoryRepository();
    
    public Event createEvent(String name, Integer categoryId, Date eventDate,
            String description, ApproveRule approveRule,
            PaymentRule paymentRule, Availability availability,
            BigDecimal cost, Integer companyId) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
        
        Category category = _catRep.get(categoryId);
        Company company = _compRep.get(companyId);
        
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
}
