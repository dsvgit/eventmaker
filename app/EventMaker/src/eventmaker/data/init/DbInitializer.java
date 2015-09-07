package eventmaker.data.init;

import eventmaker.core.repository.CategoryRepository;
import eventmaker.core.repository.CompanyRepository;
import eventmaker.core.repository.EventRepository;
import eventmaker.core.repository.RegistrationRepository;
import eventmaker.core.repository.UserRepository;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.Category;
import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.Organizer;
import eventmaker.data.Registration;
import eventmaker.data.User;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.ApproveState;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.enums.PaymentState;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import java.math.BigDecimal;
import java.util.Date;

public class DbInitializer {
    
    static CompanyRepository _cmpRep = new CompanyRepository();
    static UserRepository _userRep = new UserRepository();
    static CategoryRepository _categoryRep = new CategoryRepository();
    static EventRepository _eventRep = new EventRepository();
    static RegistrationRepository _regRep = new RegistrationRepository();
    
    public static void initialize() throws RepositoryException,
            DifferentObjectInIdentityMapException {
        User u1 = new User("Ivan", "Ivanov", "ivan", "director");
        User u2 = new User("Alex", "Smith", "asmith", "1");
        User u3 = new User("John", "White", "jwhite", "director");
        User u4 = new User("Jane", "Cooper", "ivan1", "director");
        
        Organizer org1 = new Organizer("Sergey", "Dedkov", "dsv", "director", "dsv.mail@yandex.ru");
        Organizer org2 = new Organizer("Roman", "Smith", "rr", "1", "89086398518");
        
        Company cmp1 = new Company("Coca-cola", "We produce cola", org1);
        Company cmp2 = new Company("Pepsi", "We produce pepsi", org2);
        Company cmp3 = new Company("Motorolla", "We produce phones", org2);
        Company cmp4 = new Company("Nokia", "We produce phones", org1);
        Company cmp5 = new Company("Ferarri", "We produce cars", org2);
        
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
        
        Registration r1 = new Registration(ev1, ApproveState.INVITED, 
                PaymentState.NOT_PAID, u1);
        Registration r2 = new Registration(ev1, ApproveState.INVITED, 
                PaymentState.ON_ADMIN_CONFIRMATION, u2);
        Registration r3 = new Registration(ev1, ApproveState.CLAIMED, 
                PaymentState.ON_ORGANIZER_CONFIRMATION, u3);
        Registration r4 = new Registration(ev2, ApproveState.APPROVED, 
                PaymentState.PAID, u2);
        Registration r5 = new Registration(ev3, ApproveState.CLAIMED, 
                PaymentState.NOT_PAID, u4);
        Registration r6 = new Registration(ev3, ApproveState.APPROVED, 
                PaymentState.ON_ORGANIZER_CONFIRMATION, u4);
        Registration r7 = new Registration(ev2, ApproveState.INVITED, 
                PaymentState.PAID, u2);
        
        
        _userRep.storeBatch(u1, u2, u3, u4, org1, org2);
        _cmpRep.storeBatch(cmp1, cmp2, cmp3, cmp4, cmp5);
        _categoryRep.storeBatch(cat1, cat2);
        _eventRep.storeBatch(ev1, ev2, ev3);
        _regRep.storeBatch(r1, r2, r3, r4, r5, r6, r7);
    }
}
