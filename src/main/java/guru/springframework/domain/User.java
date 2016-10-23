package guru.springframework.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends IdEntity {

    @Column(name = "login", nullable = false)
    @Size(min = 3)
    private String login;


    @Column(name = "pass", nullable = false)
    @Size(min = 5)
    private String password;

    @Column(name = "fullName", nullable = false)
    @Size(min = 5)
    private String fullName;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Contact> contacts;


    public User() {
    }

    public User(String login, String password, String firstNameLastNameFathersName) {
        this.login = login;
        this.password = password;
        fullName = firstNameLastNameFathersName;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
