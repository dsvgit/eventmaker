/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.managers;

import eventmaker.data.User;
import eventmaker.repository.IUserRepository;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.UserRepository;
import java.util.List;

/**
 *
 * @author dsvma_000
 */
public class UserManager {
    private final IUserRepository _userRep = new UserRepository();
    
    public User create(String firstName, String lastName, String login, String info) throws RepositoryException {
        User user = new User(firstName, lastName, login, info, false);
        _userRep.store(user);
        return user;
    }
    
    public User get(Integer id) throws RepositoryException {
        return _userRep.get(id);
    }
    
    public User getUserByName(String name) throws RepositoryException {
        return _userRep.getUserByLogin(name);
    }
    
    public List<User> getList() throws RepositoryException {
        return _userRep.getList();
    }
}
