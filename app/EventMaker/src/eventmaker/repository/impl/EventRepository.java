package eventmaker.repository.impl;

import eventmaker.repository.shared.Repository;
import eventmaker.data.Event;
import eventmaker.repository.IEventRepository;

public class EventRepository extends Repository<Event, Integer> implements IEventRepository{
    
    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }
    
}
