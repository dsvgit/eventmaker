package eventmaker.data.init;

import eventmaker.core.repository.CompanyRepository;
import eventmaker.core.repository.UserRepository;
import eventmaker.core.repository.exceptions.RepositoryException;
import eventmaker.data.Company;
import eventmaker.data.User;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;

public class DbInitializer {
    
    static CompanyRepository _cmpRep = new CompanyRepository();
    static UserRepository _userRep = new UserRepository();
    
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
        
        _userRep.storeBatch(u1, u2, u3, u4);
        _cmpRep.storeBatch(cmp1, cmp2, cmp3, cmp4, cmp5);
    }
}
