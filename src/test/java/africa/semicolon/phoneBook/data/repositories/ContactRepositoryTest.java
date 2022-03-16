package africa.semicolon.phoneBook.data.repositories;


import africa.semicolon.phoneBook.data.models.Contact;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.hamcrest.CoreMatchers.is;

@DataMongoTest
public class ContactRepositoryTest {

    @Autowired
    private ContactRepository repository;

    @Test
    public void saveContactTest(){
        Contact contact = new Contact();
        contact.setFirstName("No");
        contact.setLastName("No");
        contact.setMobile("08124884392");
        Contact savedContact = repository.save(contact);
        assertNotNull(savedContact.getId());
//        assertEquals(1,repository.count());
        assertThat(savedContact.getId(),is(notNullValue()));
        assertThat(repository.count(), is(1L));
    }
}
