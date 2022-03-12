package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
  ContactRepository contactRepository;
  @BeforeEach
    void setUp() throws Exception {contactRepository = new ContactRepositoryImpl();}

    @Test void contactCanBeSavedTest() throws Exception {
      Contact contact = new Contact("Ade","Deji","09000");
      contactRepository.saveContact(contact);
      assertEquals(1,contactRepository.count());
    }

    @Test void contactCanBeDeletedTest() {
      Contact contact = new Contact("Ade","Deji","09000");
      contactRepository.saveContact(contact);
      Contact contact2 = new Contact("Ade","Deji","09000");
      contactRepository.saveContact(contact2);

      assertEquals(2,contactRepository.count());

      contactRepository.deleteContact(contact);
      assertEquals(1,contactRepository.count());
    }

    @Test void findByName() {
      Contact contact = new Contact("Ade","Deji","09000");
      contactRepository.saveContact(contact);
      Contact contact2 = new Contact("Inc","Lois","09000");
      contactRepository.saveContact(contact2);

      Contact foundContact = contactRepository.findBy("Inc");

      assertEquals(contact2,foundContact);
    }

    @Test void findByName_ignoreCase(){
      Contact contact = new Contact("Ade","Deji","09000");
      contactRepository.saveContact(contact);
      Contact contact2 = new Contact("Inc","Lois","09000");
      contactRepository.saveContact(contact2);

      Contact foundContact = contactRepository.findBy("inc");

      assertEquals(foundContact,contact2);
    }

    @Test void findByNumber(){
      Contact contact = new Contact("Ade","Deji","09000");
      contactRepository.saveContact(contact);
      Contact contact2 = new Contact("Inc","Lois","09000");
      contactRepository.saveContact(contact2);
      Contact foundContact = contactRepository.findByNumber("09000");

      assertEquals(foundContact,contact);
    }

}