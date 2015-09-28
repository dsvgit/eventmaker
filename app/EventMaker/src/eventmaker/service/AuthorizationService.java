package eventmaker.service;

import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.transactionScripts.AuthorizationTransactionScripts;
import eventmaker.repository.exceptions.RepositoryException;

public class AuthorizationService {
    AuthorizationTransactionScripts _aManager = new AuthorizationTransactionScripts();
    
    public void Login(String login, String password) throws RepositoryException, UserAuthorizationException {
        _aManager.Login(login, password);
    }
    
    public void AdminLogin(String login, String password) throws RepositoryException, UserAuthorizationException {
        _aManager.AdminLogin(login, password);
    }
}