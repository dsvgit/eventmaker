package eventmaker.data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.apache.commons.lang3.Validate;

@javax.persistence.Entity
@Table(name = "company")
public class Company extends Entity {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private String id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="organizer_id")
    private String organazer;
    
    public Company() {
    }
    
    public Company(final String id,final String name,final String description,final String organazer) {
        Validate.notNull(id, "id is required");
        Validate.notNull(name, "name is required");
        Validate.notNull(description, "description is required");
        Validate.notNull(organazer, "organazer is required");
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.organazer = organazer;
    }
    
    public String getOrganazer() {
        return organazer;
    }

    public void setOrganazer(String organazer) {
        this.organazer = organazer;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }      

    @Override
    public Object getIdentifier() {
        return id;
    }
}
