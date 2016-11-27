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

}