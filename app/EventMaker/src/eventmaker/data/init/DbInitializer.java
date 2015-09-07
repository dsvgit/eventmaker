package eventmaker.data.init;

import eventmaker.core.repository.CategoryRepository;
import eventmaker.core.repository.CompanyRepository;
import eventmaker.core.repository.EventRepository;
import eventmaker.core.repository.UserRepository;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.Category;
import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.User;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import java.math.BigDecimal;
import java.util.Date;

public class DbInitializer {
    
    static CompanyRepository _cmpRep = new CompanyRepository();
    static UserRepository _userRep = new UserRepository();
    static CategoryRepository _categoryRep = new CategoryRepository();
    static EventRepository _eventRep = new EventRepository();
    
    public static void initialize() throws RepositoryException, DifferentObjectInIdentityMapException {
        User u1 = new User("Ivan", "Ivanov", "ivan", "director");
        User u2 = new User("Alex", "Smith", "asmith", "1");
        User u3 = new User("John", "White", "jwhite", "director");
        User u4 = new User("Jane", "Cooper", "ivan1", "director");
        
        Company cmp1 = new Company("Coca-cola", "We produce cola", u1);
        Company cmp2 = new Company("Pepsi", "We produce pepsi", u2);
        Company cmp3 = new Company("Motorolla", "We produce phones", u2);
        Company cmp4 = new Company("Nokia", "We produce phones", u3);
        Company cmp5 = new Company("Ferarri", "We produce cars", u4);
        
        Category cat1 = new Category("conference");
        Category cat2 = new Category("party");
        
        Event ev1 = new Event("Part holiday!", cat2, new Date(), 
                "party in new buisness centre", ApproveRule.USER,
                PaymentRule.FREE, Availability.OPENED, null, cmp1);
        Event ev2 = new Event("Computer science", cat1, new Date(), 
                "lections about java", ApproveRule.USER,
                PaymentRule.CHARGE, Availability.OPENED, new BigDecimal(1000),
                cmp4);
        Event ev3 = new Event("St. Patrick day", cat2, new Date(), 
                "welcome to the out bar", ApproveRule.BOTH,
                PaymentRule.CHARGE, Availability.CLOSED, null, cmp2);
        
        _userRep.storeBatch(u1, u2, u3, u4);
        _cmpRep.storeBatch(cmp1, cmp2, cmp3, cmp4, cmp5);
        _categoryRep.storeBatch(cat1, cat2);
        _eventRep.storeBatch(ev1, ev2, ev3);
    }
}
