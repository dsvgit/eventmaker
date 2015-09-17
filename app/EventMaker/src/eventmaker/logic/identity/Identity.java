package eventmaker.logic.identity;

import eventmaker.data.User;
import eventmaker.repository.IUserRepository;
import eventmaker.repository.impl.UserRepository;

public class Identity implements IIdentity {
    
    private final IUserRepository _uRep = new UserRepository();
    
    @Override
    public User getUser() {
        return (User) _uRep.getUserByName("admin");
    }    
}
