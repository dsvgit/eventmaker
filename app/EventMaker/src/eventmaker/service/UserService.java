package eventmaker.service;

import eventmaker.data.User;
import eventmaker.logic.transactionScripts.UserTransactionScripts;
import eventmaker.repository.exceptions.RepositoryException;

import java.util.List;

public class UserService {
    UserTransactionScripts _uManager = new UserTransactionScripts();
    
    public User create(String firstName, String lastName, String login, String info) throws RepositoryException {
        return _uManager.create(firstName, lastName, login, info);
    }
    
    public User get(Integer id) throws RepositoryException {
        return _uManager.get(id);
    }
    
    public User getUserByName(String name) throws RepositoryException {
        return _uManager.getUserByName(name);
    }
    
    public List<User> getList() throws RepositoryException {
        return _uManager.getList();
    }
}
