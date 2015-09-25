package eventmaker.logic.managers;

import eventmaker.data.Event;
import eventmaker.data.Registration;
import eventmaker.data.User;
import eventmaker.data.enums.ApproveState;
import eventmaker.data.enums.PaymentState;
import eventmaker.logic.identity.IIdentity;
import eventmaker.logic.identity.Identity;
import eventmaker.logic.identity.UserAuthorizationException;
import eventmaker.repository.IRegistrationRepository;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.RegistrationRepository;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationManager {
    private final IRegistrationRepository _regsRepository = new RegistrationRepository();
    private final EventManager _evManager = new EventManager();
    private final UserManager _userManager = new UserManager();
    private final IIdentity _identity = Identity.getInstance();
    
    public List<Registration> getList() throws RepositoryException {
        return _regsRepository.getList();
    }
    
    public Registration inviteUser(Integer userId, Integer eventId) throws RepositoryException {
        User user = _userManager.get(userId);
        Event event = _evManager.get(eventId);
        ApproveState approveState = ApproveState.INVITED;
        PaymentState paymentState;
        switch (event.getPaymentRule())
        {
            case CHARGE:
                paymentState = PaymentState.NOT_PAID;
                break;
            case FREE:
                paymentState = null;
                break;
            default:
                paymentState = null;
        }
        
        Registration reg = new Registration(
                event, 
                approveState, 
                paymentState,
                user
        );
        _regsRepository.store(reg);
        return reg;
    }

    public List<Registration> getListByEvent(Integer id) throws RepositoryException {
        Event event = _evManager.get(id);
        return _regsRepository.getByEvent(event);
    }
    
    public List<Registration> getByCurrentUser() throws RepositoryException {
        try {
            return _regsRepository.getByUser(_identity.getUser());
        } catch (UserAuthorizationException ex) {
            Logger.getLogger(RegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException();
        }
    }
}
