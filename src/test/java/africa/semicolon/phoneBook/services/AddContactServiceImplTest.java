package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddContactServiceImplTest {
    ContactRepository contactRepository;
    @BeforeEach void setUp(){
        contactRepository = new ContactRepositoryImpl();
    }

    @Test void testThatAContactCanBeAdded() {
        //given that
        AddContactService addContactService = new AddContactServiceImpl();
        AddContactRequest requests = new AddContactRequest();
        requests.setFirstName("Lekan");
        requests.setLastName("Ola");
        requests.setMobile("08124884392");
        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("Lekan");
        request2.setLastName("Ola");
        request2.setMobile("08124884392");

        addContactService.save(requests);
        addContactService.save(request2);


        //assert
        assertEquals(2,addContactService.getRepository().count());
    }

    @Test void contactCanBeFoundByName(){
        AddContactService addContactService = new AddContactServiceImpl();
        AddContactRequest requests = new AddContactRequest();
        requests.setFirstName("Lekan");
        requests.setLastName("Ola");
        requests.setMobile("08124884392");
        addContactService.save(requests);
        FindUserResponse response = addContactService.findUserByName("Lekan");

        assertEquals("Lekan Ola",response.getFullName());
    }

    @Test void deleteContact() {
        AddContactService addContactService = new AddContactServiceImpl();
        AddContactRequest requests = new AddContactRequest();
        requests.setFirstName("Lekan");
        requests.setLastName("Ola");
        requests.setMobile("08124884392");

        AddContactRequest request2 = new AddContactRequest();
        request2.setFirstName("Lekan");
        request2.setLastName("Ola");
        request2.setMobile("08124884392");
        addContactService.save(requests);
        addContactService.save(request2);
        assertEquals(2,addContactService.getRepository().count());
        addContactService.delete(requests);
        assertEquals(1,addContactService.getRepository().count());
    }

    @Test void contactCanBeFoundByMobile(){
        AddContactService addContactService = new AddContactServiceImpl();
        AddContactRequest requests = new AddContactRequest();
        requests.setFirstName("Lekan");
        requests.setLastName("Ola");
        requests.setMobile("08124884392");
        addContactService.save(requests);
        FindUserResponse response = addContactService.findUserByMobile("08124884392");

        assertEquals("08124884392",response.getMobileNumber());
    }


}