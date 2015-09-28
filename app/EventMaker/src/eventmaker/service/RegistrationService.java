package eventmaker.service;

import eventmaker.data.Registration;
import eventmaker.data.User;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.logic.managers.RegistrationManager;
import eventmaker.repository.exceptions.RepositoryException;

import java.util.List;

public class RegistrationService {
    RegistrationManager _regManager = new RegistrationManager();
    
    public List<Registration> getList() throws RepositoryException {
        return _regManager.getList();
    }
    
    public Registration inviteUser(Integer userId, Integer eventId) throws RepositoryException {
        return _regManager.inviteUser(userId, eventId);
    }

    public List<Registration> getListByEvent(Integer id) throws RepositoryException {
        return _regManager.getListByEvent(id);
    }
    
    public List<Registration> getByCurrentUser() throws RepositoryException {
        return _regManager.getByCurrentUser();
    }
    
    public Registration getByCurrentUserAndEvent(User user, Integer eventId) throws RepositoryException {
        return _regManager.getByCurrentUserAndEvent(user, eventId);
    }

    public void claimCurrentUser(Integer eventId) throws RepositoryException, UserAuthorizationException {
        _regManager.claimCurrentUser(eventId);
    }

    public void confirmRegistration(Registration reg) throws RepositoryException {
        _regManager.confirmRegistration(reg);
    }

    public void UserApprove(Registration reg) throws RepositoryException {
        _regManager.UserApprove(reg);
    }

    public void declineRegistration(Registration reg) throws RepositoryException {
        _regManager.declineRegistration(reg);
    }

    public void userPayEvent(Registration reg) throws RepositoryException {
        _regManager.userPayEvent(reg);
    }

    public List<Registration> getToAdminConfirmation() {
        return _regManager.getToAdminConfirmation();
    }

    public void adminConfirm(Registration reg) throws RepositoryException {
        _regManager.adminConfirm(reg);
    }

    public void organizerConfirm(Registration reg) throws RepositoryException {
        _regManager.organizerConfirm(reg);
    }
}
