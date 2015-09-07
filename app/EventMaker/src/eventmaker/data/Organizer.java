package eventmaker.data;

import eventmaker.core.repository.CompanyRepository;
import eventmaker.core.repository.EventRepository;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@javax.persistence.Entity
@DiscriminatorValue("regularemployee")  
public class Organizer extends User {
    
    @Column(name="contact")  
    private String contact;

    public Organizer() {
    }

    public Organizer(String contact) {
        this.contact = contact;
    }

    public Organizer(String firstName, String lastName, String login,
            String info, String contact) {
        super(firstName, lastName, login, info);
        this.contact = contact;
    }
    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    public Company createCompany(String name, String description) {
        CompanyRepository _cmpRep = new CompanyRepository();
        Company cmp = new Company(name, description, this);
        try {
            _cmpRep.store(cmp);
        } catch (RepositoryException | DifferentObjectInIdentityMapException ex) {
            Logger.getLogger(Organizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cmp;
    }
    
    public Event createEvent(String name, Category category, Date eventDate,
            String description, ApproveRule approveRule,
            PaymentRule paymentRule, Availability availability,
            BigDecimal cost, Company company) {
        EventRepository _eventRep = new EventRepository();
        Event event = new Event(name, category, eventDate, 
                description, approveRule,
                paymentRule, availability, cost, company);
        
        try {
            _eventRep.store(event);
        } catch (RepositoryException | DifferentObjectInIdentityMapException ex) {
            Logger.getLogger(Organizer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return event;
    }
}
