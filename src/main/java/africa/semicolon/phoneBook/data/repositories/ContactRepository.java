package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;

public interface ContactRepository {
    Contact saveContact(Contact contact);
    void deleteContact(Contact contact);
    Contact findBy(String name);
    Contact findByNumber(String number);

    int count();

    ContactRepository getRepository();


}
