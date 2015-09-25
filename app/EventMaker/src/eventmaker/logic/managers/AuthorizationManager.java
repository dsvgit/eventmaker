package eventmaker.logic.managers;

import eventmaker.data.User;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.repository.exceptions.RepositoryException;

public class AuthorizationManager {
    public void Login(String login, String password) throws RepositoryException, UserAuthorizationException {
        IIdentity identity = Identity.getInstance();
        UserManager userManager = new UserManager();
        User currentUser = userManager.getUserByName(login);
        if (currentUser == null) throw new UserAuthorizationException();
        identity.setUser(currentUser);
    }
}