package eventmaker.repository.impl;

import eventmaker.repository.ICompanyRepository;
import eventmaker.repository.shared.Repository;
import eventmaker.data.Company;

public class CompanyRepository extends Repository<Company, Integer> implements ICompanyRepository {

    @Override
    protected Class<Company> getDomainClass() {
        return Company.class;
    }
}
