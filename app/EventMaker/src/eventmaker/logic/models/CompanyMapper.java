package eventmaker.logic.models;

import eventmaker.data.Company;

public class CompanyMapper {
    public VCompany Map(Company cmp) {
        VCompany vCmp = new VCompany();
        vCmp.name = cmp.getName();
        return vCmp;
    }
}
