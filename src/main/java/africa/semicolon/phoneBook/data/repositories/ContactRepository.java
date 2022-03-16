package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ContactRepository extends MongoRepository<Contact, String> {
    List<Contact> findContactByFirstName(String firstName);
    Contact findContactByFirstNameAndLastName(String firstName, String lastName);
    List<Contact> findContactByFirstNameOrLastName(String name);
    List<Contact> findContactByLastName(String lastName);
    Contact findContactByMobile(String mobile);

}
