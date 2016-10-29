package guru.springframework.services;

import guru.springframework.domain.Contact;
import guru.springframework.domain.User;

public interface UserService {

    User registerUser(String fullName, String login, String password);

    User logInUser(String login, String password);

    boolean logOffUser(long userId);

    User getUserById(long userId);

    User findUserByName(String name);

    Contact addContact(String firstName, String secondName, String fathersName, String mobilePhoneNumber,
                       String homePhoneNumber, String homeAddress, String email, long userId);

    Iterable<Contact> findAllContacts();

    boolean deleteContact(Contact contact);

    Contact findContactById(long contactId);

    Contact findContactByFirstName(String firstName);

    Contact findContactBySecondName(String secondName);

    Contact findContactByFuthersName(String futhersName);

}
