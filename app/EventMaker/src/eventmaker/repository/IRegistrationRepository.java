package eventmaker.repository;

import eventmaker.repository.shared.IRepository;
import eventmaker.data.Event;
import eventmaker.data.Registration;
import java.util.List;

public interface IRegistrationRepository extends IRepository<Registration> {
    List<Registration> getByEvent(Event event);
}
