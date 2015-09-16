package eventmaker.logic.identity;

import eventmaker.data.Organizer;
import eventmaker.repository.IUserRepository;
import eventmaker.repository.impl.UserRepository;

public class IdentityOrganizer implements IIdentity {
    
    private final IUserRepository _uRep = new UserRepository();
    
    @Override
    public Organizer getUser() {
        return (Organizer) _uRep.getUserByName("admin");
    }    
}
