package eventmaker.logic.managers;

import eventmaker.data.User;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.repository.IUserRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.UserRepository;
import java.util.List;

public class UserManager {
    private final IUserRepository _userRep = new UserRepository();
    
    public User create(String firstName, String lastName, String login, String info) throws RepositoryException, DifferentObjectInIdentityMapException {
        User user = new User(firstName, lastName, login, info);
        _userRep.store(user);
        return user;
    }
    
    public User get(Integer id) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
        return _userRep.get(id);
    }
    
    public User getUserByName(String name) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
        return _userRep.getUserByLogin(name);
    }
    
    public List<User> getList() throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return _userRep.getList();
    }
}
