package eventmaker.repository;

import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.repository.shared.IRepository;
import java.util.List;

public interface IEventRepository extends IRepository<Event> {

    List<Event> getListByCompany(Company cmp);

    public List<Event> getListOpened();
    
}
