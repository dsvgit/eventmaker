/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eventmaker.logic.transactionScripts;

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
import eventmaker.service.EventService;
import eventmaker.service.RegistrationService;
import eventmaker.service.UserService;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dsvma_000
 */
public class RegistrationTransactionScripts {
    private final IRegistrationRepository _regsRepository = new RegistrationRepository();
    private final EventService _evManager = new EventService();
    private final UserService _userManager = new UserService();
    private final IIdentity _identity = Identity.getInstance();
    
    public List<Registration> getList() throws RepositoryException {
        return _regsRepository.getList();
    }
    
    public Registration inviteUser(Integer userId, Integer eventId) throws RepositoryException {
        User user = _userManager.get(userId);
        Event event = _evManager.get(eventId);
        ApproveState approveState = ApproveState.INVITED;
        PaymentState paymentState = getFirstPaymentState(event);
        
        Registration reg = new Registration(
                event, 
                approveState, 
                paymentState,
                user
        );
        if (getByCurrentUserAndEvent(user, eventId) != null) return reg;
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
            Logger.getLogger(RegistrationService.class.getName()).log(Level.SEVERE, null, ex);
            throw new RepositoryException();
        }
    }
    
    public Registration getByCurrentUserAndEvent(User user, Integer eventId) throws RepositoryException {
        return _regsRepository.getByUserAndEvent(user, eventId);
    }

    public void claimCurrentUser(Integer eventId) throws RepositoryException, UserAuthorizationException {
        User user = _userManager.get(_identity.getUser().getId());
        Event event = _evManager.get(eventId);
        ApproveState approveState = getClaimedApproveState(event);
        PaymentState paymentState = getFirstPaymentState(event);
        
        Registration reg = new Registration(
                event, 
                approveState, 
                paymentState,
                user
        );
        _regsRepository.store(reg);
    }
    
    private PaymentState getFirstPaymentState(Event event) {
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
        return paymentState;
    }
    
    private ApproveState getClaimedApproveState(Event event) {
        ApproveState approveState;
        switch (event.getApproveRule())
        {
            case BOTH:
                approveState = ApproveState.CLAIMED;
                break;
            case USER:
                approveState = ApproveState.APPROVED;
                break;
            default:
                approveState = null;
        }
        return approveState;
    }

    public void confirmRegistration(Registration reg) throws RepositoryException {
        if (reg.getApproveState() == ApproveState.CLAIMED) {
            reg.setApproveState(ApproveState.APPROVED);
        }
        _regsRepository.store(reg);
    }

    public void UserApprove(Registration reg) throws RepositoryException {
        if (reg.getApproveState() == ApproveState.INVITED) {
            reg.setApproveState(ApproveState.APPROVED);
        }
        _regsRepository.store(reg);
    }

    public void declineRegistration(Registration reg) throws RepositoryException {
        _regsRepository.remove(reg);
    }

    public void userPayEvent(Registration reg) throws RepositoryException {
        if (reg.getPaymentState() == PaymentState.NOT_PAID) {
            reg.setPaymentState(PaymentState.ON_ADMIN_CONFIRMATION);
        }
        _regsRepository.store(reg);
    }

    public List<Registration> getToAdminConfirmation() {
        return _regsRepository.getToAdminConfirmation();
    }

    public void adminConfirm(Registration reg) throws RepositoryException {
        if (reg.getPaymentState() == PaymentState.ON_ADMIN_CONFIRMATION) {
            reg.setPaymentState(PaymentState.ON_ORGANIZER_CONFIRMATION);
        }
        _regsRepository.store(reg);
    }

    public void organizerConfirm(Registration reg) throws RepositoryException {
        if (reg.getPaymentState() == PaymentState.ON_ORGANIZER_CONFIRMATION) {
            reg.setPaymentState(PaymentState.PAID);
        }
        _regsRepository.store(reg);
    }
}
