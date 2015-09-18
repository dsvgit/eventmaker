package eventmaker.logic.models;

import eventmaker.data.Company;

public class CompanyMapper {
    public VCompany Map(Company cmp) {
        VCompany vCmp = new VCompany();
        vCmp.id = cmp.getId();
        vCmp.name = cmp.getName();
        vCmp.description = cmp.getDescription();
        return vCmp;
    }
}
