package guru.springframework.repositories;

import guru.springframework.domain.Contact;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact,Long>{

    /*@Query("SELECT '*' FROM contacts")
    Iterable<Contact> findContactsAllByQuery();*/
}
