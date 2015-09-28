package eventmaker.repository;

import eventmaker.repository.shared.IRepository;
import eventmaker.data.Company;
import eventmaker.data.User;
import java.util.List;

public interface ICompanyRepository extends IRepository<Company> {

    public List<Company> getListCurrent(User user);
    
}
