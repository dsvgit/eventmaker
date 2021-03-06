package eventmaker.data;

import eventmaker.data.shared.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "app_user")
public class User extends Entity {
    
    @Id
    @GeneratedValue
    @Column(name="id")
    private Integer id;
    
    @Column(name="fname")
    private String firstName;
    
    @Column(name="lname")
    private String lastName;
    
    @Column(name="login")
    private String login;
    
    @Column(name="info")
    private String info;
    
    @Column(name="is_admin")
    private Boolean isAdmin;

    public Boolean isAdmin() {
        return isAdmin;
    }

    public void changeAdminState(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public User() {
    }

    public User(String firstName, String lastName, String login, String info, Boolean isAdmin) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.info = info;
        this.isAdmin = isAdmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public Object getIdentifier() {
        return id;
    }
    
}
