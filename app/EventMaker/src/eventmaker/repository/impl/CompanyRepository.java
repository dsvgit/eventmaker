package eventmaker.repository.impl;

import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.shared.Repository;
import eventmaker.data.Company;
import eventmaker.data.Event;
import eventmaker.data.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class CompanyRepository extends Repository<Company, Integer> implements ICompanyRepository {

    @Override
    protected Class<Company> getDomainClass() {
        return Company.class;
    }

    @Override
    public List<Company> getListCurrent(User user) {
        Session session = sessFact.openSession();
        org.hibernate.Transaction tr = session.beginTransaction();
        List<Company> list = session
                .createCriteria(getDomainClass())
                .add(Restrictions.eq("organizer.id", user.getIdentifier()))
                .list();
        tr.commit();
        session.close();
        
        return list;
    }
}
