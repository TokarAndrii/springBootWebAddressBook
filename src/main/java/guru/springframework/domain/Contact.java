package guru.springframework.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

// todo little first char
// id @Table
@Entity
@Table(name = "contacts")
public class Contact {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "firstName", nullable = false)
    @Size(min = 4)
    private String firstName;

    @Column(name = "secondName", nullable = false)
    @Size(min = 4)
    private String secondName;

    @Column(name = "fathersName", nullable = false)
    @Size(min = 4)
    private String fathersName;

    @Column(name = "mobilePhoneNumber", nullable = false)
    @Size(min = 15, max = 15)
    private String mobilePhoneNumber;

    @Column(name = "homePhoneNumber", nullable = true)
    private String homePhoneNumber;

    @Column(name = "homeAddress", nullable = true)
    private String homeAddress;

    @Column(name = "email", nullable = true)
    private String email;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Contact() {
    }

    public Contact(String firstName, String secondName, String fathersName, String mobilePhoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public Contact(String firstName, String secondName, String fathersName, String mobilePhoneNumber,
                   String homePhoneNumber, String homeAddress, String email, User user) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.fathersName = fathersName;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.homePhoneNumber = homePhoneNumber;
        this.homeAddress = homeAddress;
        this.email = email;
        this.user = user;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getFathersName() {
        return fathersName;
    }

    public void setFathersName(String fathersName) {
        this.fathersName = fathersName;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getHomePhoneNumber() {
        return homePhoneNumber;
    }

    public void setHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", fathersName='" + fathersName + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", homePhoneNumber='" + homePhoneNumber + '\'' +
                ", homeAddress='" + homeAddress + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

