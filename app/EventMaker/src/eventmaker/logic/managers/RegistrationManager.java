package eventmaker.logic.managers;

import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.Registration;
import eventmaker.data.User;
import eventmaker.data.enums.ApproveState;
import eventmaker.data.enums.PaymentRule;
import eventmaker.data.enums.PaymentState;
import eventmaker.data.exceptions.DifferentObjectInIdentityMapException;
import eventmaker.repository.IRegistrationRepository;
import eventmaker.repository.exceptions.NotFoundException;
import eventmaker.repository.exceptions.RepositoryException;
import eventmaker.repository.impl.RegistrationRepository;
import java.util.List;

public class RegistrationManager {
    private final IRegistrationRepository _regsRepository = new RegistrationRepository();
    private final EventManager _evManager = new EventManager();
    private final UserManager _userManager = new UserManager();
    
    public List<Registration> getList() throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        return _regsRepository.getList();
    }
    
    public Registration inviteUser(Integer userId, Integer eventId) throws RepositoryException, DifferentObjectInIdentityMapException, NotFoundException {
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

    public List<Registration> getListByEvent(Integer id) throws RepositoryException, NotFoundException, DifferentObjectInIdentityMapException {
        Event event = _evManager.get(id);
        return _regsRepository.getByEvent(event);
    }
}
