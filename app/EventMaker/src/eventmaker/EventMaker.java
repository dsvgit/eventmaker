package eventmaker;

import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.data.enums.ApproveRule;
import eventmaker.data.enums.Availability;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.data.init.DbInitializer;
import eventmaker.hibernate.HibernateUtil;
import eventmaker.logic.services.CompanyService;
import eventmaker.logic.services.EventService;
import java.math.BigDecimal;
import java.util.Date;

public class EventMaker {

    public static void main(String[] args) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
       
        DbInitializer.initialize();       
        
        CompanyService _cmpService = new CompanyService();
        EventService evService = new EventService();
        evService.createEvent(
                "Party",
                1, 
                new Date(), 
                "description", 
                ApproveRule.BOTH, 
                PaymentRule.FREE, 
                Availability.OPENED, 
                new BigDecimal(100), 
                5
        );
        
        HibernateUtil.shutdown();
    }
}
