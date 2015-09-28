package eventmaker.repository;

import eventmaker.repository.shared.IRepository;
import eventmaker.data.Event;
import eventmaker.data.Registration;
import eventmaker.data.User;
import java.util.List;

public interface IRegistrationRepository extends IRepository<Registration> {
    List<Registration> getByEvent(Event event);

    public List<Registration> getByUser(User user);

    public Registration getByUserAndEvent(User user, Integer eventId);

    public List<Registration> getToAdminConfirmation();
}
