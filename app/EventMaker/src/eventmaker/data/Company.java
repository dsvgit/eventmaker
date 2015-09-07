package eventmaker.data;

import eventmaker.data.shared.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    
    @ManyToOne
    @JoinColumn(name = "uid")
    private Organizer organizer;
    
    public Company() {
    }

    public Company(String name, String description, Organizer organaizer) {
        this.name = name;
        this.description = description;
        this.organizer = organaizer;
    }
    
    public User getOrganizer() {
        return organizer;
    }

    public void setOrganazer(Organizer organazer) {
        this.organizer = organazer;
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
