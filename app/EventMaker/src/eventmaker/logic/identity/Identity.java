package eventmaker.logic.identity;

import eventmaker.data.User;
import eventmaker.repository.IUserRepository;
import eventmaker.repository.impl.UserRepository;

public class Identity implements IIdentity {
    
    private static Identity instance;
    private User _user;
    private final IUserRepository _uRep = new UserRepository();
    
    public static synchronized Identity getInstance() {
        if (instance == null) {
            instance = new Identity();
        }
        return instance;
    }    
    
    @Override
    public void setUser(User user) {
        _user = user;
    }
    
    @Override
    public User getUser() throws UserAuthorizationException{
        if (_user == null) throw new UserAuthorizationException();
        return _user;
    }
}
