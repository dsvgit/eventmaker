package eventmaker.logic.identity;

import eventmaker.data.User;

public interface IIdentity {
    User getUser() throws UserAuthorizationException;
    void setUser(User user);
}
