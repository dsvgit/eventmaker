/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.transactionScripts;

import eventmaker.data.User;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.service.UserService;

/**
 *
 * @author dsvma_000
 */
public class AuthorizationTransactionScripts {
    public void Login(String login, String password) throws RepositoryException, UserAuthorizationException {
        IIdentity identity = Identity.getInstance();
        UserService userManager = new UserService();
        User currentUser = userManager.getUserByName(login);
        if (currentUser == null) throw new UserAuthorizationException();
        identity.setUser(currentUser);
    }
    
    public void AdminLogin(String login, String password) throws RepositoryException, UserAuthorizationException {
        IIdentity identity = Identity.getInstance();
        UserService userManager = new UserService();
        User currentUser = userManager.getUserByName(login);
        if (currentUser == null && currentUser.isAdmin()) throw new UserAuthorizationException();
        identity.setUser(currentUser);
    }
}
