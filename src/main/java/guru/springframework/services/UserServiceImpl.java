package guru.springframework.services;


import guru.springframework.domain.Contact;
import guru.springframework.domain.User;
import guru.springframework.repositories.ContactRepository;
import guru.springframework.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ContactRepository contactRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Autowired
    public void setContactRepository(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public User registerUser(String fullName, String login, String password) {
        if (fullName != null && login != null && password != null) {
            User user = new User(login, password, fullName);
            userRepository.save(user);
            return user;
        }

        return null;
    }

    @Override
    public User logInUser(String login, String password) {
        return null;
    }

    @Override
    public boolean logOffUser(long userId) {
        return false;
    }

    @Override
    public User getUserById(long userId) {
        if (userId != 0) {
            User found = userRepository.findOne(userId);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public Contact addContact(String firstName, String secondName, String fathersName,
                              String mobilePhoneNumber, String homePhoneNumber,
                              String homeAddress, String email, long userId) {
        //TO DO FIND USER FROW WEB PAGE

        Contact contact = new Contact(firstName, secondName, fathersName, mobilePhoneNumber,
                homePhoneNumber, homeAddress, email, userRepository.findOne(userId));

        contactRepository.save(contact);
        return null;
    }

    @Override
    public Iterable<Contact> findAllContacts(long userId) {
        /*if (contactRepository.findAll() != null) {
            return contactRepository.findAll();
        }
        return null;*/

        return contactRepository.findAllUsersContacts(userId);
    }

    @Override
    public boolean deleteContact(Contact contact) {

        if (contact != null) {
            //contactRepository.delete(contact);
            long idContact = contact.getId();
            contactRepository.deleteOneContact(idContact);
            return true;
        }

        return false;
    }

    @Override
    public Contact findContactById(long contactId) {
        if (contactId != 0) {
            Contact found = contactRepository.findOne(contactId);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    @Override
    public Contact findContactByFirstName(String firstName) {
        return null;
    }

    @Override
    public Contact findContactBySecondName(String secondName) {
        return null;
    }

    @Override
    public User findUserByName(String secondName) {

        List<User> users = (List<User>) userRepository.findAll();
        if (users != null) {
            User found = null;
            for (User user : users) {
                if (user.getLogin().equals(secondName)) {
                    found = user;
                    return found;
                }
            }
        }


        return null;
    }

    @Override
    public Contact findContactByFuthersName(String futhersName) {
        return null;
    }


    public Iterable<Contact> findContactsByUserId(long userId) {

        Iterable<Contact> allContacts = findAllContacts(userId);

        ArrayList<Contact> contactsUser = new ArrayList<>();
        for (Contact contact : allContacts) {
            if (contact.getUser().getId() == userId) {

                contactsUser.add(contact);
            }
        }

        if (contactsUser != null && contactsUser.size() > 0) {
            return contactsUser;
        }

        return null;
    }


}
