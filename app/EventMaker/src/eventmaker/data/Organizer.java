package eventmaker.data;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

@javax.persistence.Entity
@DiscriminatorValue("regularemployee")  
public class Organizer extends User {
    
    @Column(name="contact")  
    private String contact;

    public Organizer() {
    }

    public Organizer(String contact) {
        this.contact = contact;
    }

    public Organizer(String firstName, String lastName, String login,
            String info, String contact) {
        super(firstName, lastName, login, info);
        this.contact = contact;
    }
    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}
