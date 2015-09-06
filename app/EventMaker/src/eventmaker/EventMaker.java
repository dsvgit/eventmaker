package eventmaker;

import eventmaker.core.repository.CompanyRepository;
import eventmaker.core.repository.exceptions.NotFoundException;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
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
            Company cmp = new Company();
            cmp.setName("NetBeans");
            cmp.setDescription("HP");
            cmp.setOrganazer(11);
            
            _cmpRep.store(cmp);
            List<Company> list = _cmpRep.getList();
            
            for (Company item : list) {
                System.out.println(item.getName());
            }           
            
        } catch (RepositoryException | DifferentObjectInIdentityMapException | NotFoundException ex) {
            Logger.getLogger(EventMaker.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HibernateUtil.shutdown();
    }
}
