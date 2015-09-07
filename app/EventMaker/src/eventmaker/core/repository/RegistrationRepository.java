package eventmaker.core.repository;

import eventmaker.core.repository.shared.Repository;
import eventmaker.data.Registration;

public class RegistrationRepository extends Repository<Registration, Integer> {

    @Override
    protected Class<Registration> getDomainClass() {
        return Registration.class;
    }
    
}
