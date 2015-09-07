package eventmaker.core.repository;

import eventmaker.core.repository.shared.Repository;
import eventmaker.data.Company;

public class CompanyRepository extends Repository<Company, Integer> {

    @Override
    protected Class<Company> getDomainClass() {
        return Company.class;
    }
}
