package guru.springframework.repositories;

import guru.springframework.domain.Contact;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    @Query("SELECT c FROM Contact c WHERE c.user.id=:userId ")
    Iterable<Contact> findAllUsersContacts(@Param("userId") long userId);

    @Modifying
    @Transactional
    @Query("DELETE  FROM guru.springframework.domain.Contact  where id=:contactId ")
    void deleteOneContact(@Param("contactId") long contactId);


    @Modifying
    @Transactional
    @Query("UPDATE guru.springframework.domain.Contact set first_name=:firstName,second_name=:secondName," +
            "fathers_name=:fathersName,home_address=:homeAddress,email=:email,home_phone_number=:homePhoneNumber," +
            "mobile_phone_number=:mobilePhoneNumber WHERE id=:contactId")
    void updateOneContact(@Param("contactId") long contactId, @Param("firstName") String firstName,
                          @Param("secondName") String secondName, @Param("fathersName") String fathersName,
                          @Param("email") String email, @Param("homeAddress") String homeAddress,
                          @Param("homePhoneNumber") String homePhoneNumber,
                          @Param("mobilePhoneNumber") String mobilePhoneNumber);

}