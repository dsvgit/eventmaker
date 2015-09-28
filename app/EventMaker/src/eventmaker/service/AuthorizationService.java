package eventmaker.service;

import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.managers.AuthorizationManager;
import eventmaker.repository.exceptions.RepositoryException;

public class AuthorizationService {
    AuthorizationManager _aManager = new AuthorizationManager();
    
    public void Login(String login, String password) throws RepositoryException, UserAuthorizationException {
        _aManager.Login(login, password);
    }
    
    public void AdminLogin(String login, String password) throws RepositoryException, UserAuthorizationException {
        _aManager.AdminLogin(login, password);
    }
}