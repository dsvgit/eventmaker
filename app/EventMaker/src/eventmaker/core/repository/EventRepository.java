package eventmaker.core.repository;

import eventmaker.core.repository.shared.Repository;
import eventmaker.data.Event;

public class EventRepository extends Repository<Event, Integer> {
    
    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }
    
}
