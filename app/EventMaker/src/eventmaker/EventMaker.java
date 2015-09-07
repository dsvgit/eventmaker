package eventmaker;

import eventmaker.core.repository.CategoryRepository;
import eventmaker.core.repository.EventRepository;
import eventmaker.core.repository.RegistrationRepository;
import eventmaker.core.repository.UserRepository;
import eventmaker.core.repository.exceptions.NotFoundException;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.Category;
import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.Organizer;
import eventmaker.data.Registration;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.init.DbInitializer;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.hibernate.HibernateUtil;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventMaker {

    public static void main(String[] args) {
        UserRepository _uRep = new UserRepository();
        CategoryRepository _catRep = new CategoryRepository();
        EventRepository _eventRep = new EventRepository();
        RegistrationRepository _regRep = new RegistrationRepository();
        
        try {
            DbInitializer.initialize();
            
            Organizer org = (Organizer) _uRep.get(5);
            Company cmp = org.createCompany("Cola", "My own company");
            Category cat = _catRep.get(1);
            org.createEvent("Party", cat, new Date(), "description", ApproveRule.BOTH, 
                    PaymentRule.FREE, Availability.OPENED, new BigDecimal(100), cmp);
            
        } catch (RepositoryException | DifferentObjectInIdentityMapException | NotFoundException ex) {
            Logger.getLogger(EventMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HibernateUtil.shutdown();
    }
}
