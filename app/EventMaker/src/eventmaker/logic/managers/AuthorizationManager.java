package eventmaker.logic.managers;

import eventmaker.data.User;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.data.init.DbInitializer;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;

public class AuthorizationManager {
    public void Login(String login, String password) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
        IIdentity identity = Identity.getInstance();
        UserManager userManager = new UserManager();
        User currentUser = userManager.getUserByName(login);
        identity.setUser(currentUser);
    }
}