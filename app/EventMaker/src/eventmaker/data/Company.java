package eventmaker.data;

import eventmaker.data.shared.ValueObject;
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
    private Integer id;
    
    @Column(name="name")
    private String name;
    
    @Column(name="description")
    private String description;
    
    @Column(name="organizer_id")
    private int organaizer;
    
    public Company() {
    }
    
    public Company(final int id,final String name,final String description,final int organazer) {
        Validate.notNull(id, "id is required");
        Validate.notNull(name, "name is required");
        Validate.notNull(description, "description is required");
        Validate.notNull(organazer, "organazer is required");
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.organaizer = organazer;
    }
    
    public int getOrganazer() {
        return organaizer;
    }

    public void setOrganazer(int organazer) {
        this.organaizer = organazer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
