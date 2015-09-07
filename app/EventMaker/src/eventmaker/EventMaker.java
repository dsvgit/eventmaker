package eventmaker;

import eventmaker.core.repository.CompanyRepository;
import eventmaker.core.repository.exceptions.NotFoundException;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
import eventmaker.data.init.DbInitializer;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.hibernate.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventMaker {

    public static void main(String[] args) {
        CompanyRepository _cmpRep = new CompanyRepository();
        
        try {
            DbInitializer.initialize();          
            
        } catch (RepositoryException | DifferentObjectInIdentityMapException ex) {
            Logger.getLogger(EventMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HibernateUtil.shutdown();
    }
}
