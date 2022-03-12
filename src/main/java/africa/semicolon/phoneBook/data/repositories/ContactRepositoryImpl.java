package africa.semicolon.phoneBook.data.repositories;

import africa.semicolon.phoneBook.data.models.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    List<Contact> db = new ArrayList<>();

    private int count;

    @Override
    public Contact saveContact(Contact contact) {
        db.add(contact);
        count++;

        return contact;
    }

    @Override
    public void deleteContact(Contact contact) {
            db.remove(contact);
            count--;
    }

    @Override
    public Contact findBy(String name) {
        for (Contact contact : db){
            if (contact.getFirstName().equalsIgnoreCase(name)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public Contact findByNumber(String number) {
        for (Contact contact : db){
            if (contact.getMobile().equals(number)){
                return contact;
            }
        }
        return null;
    }

    @Override
    public int count() {
        return db.size();
    }

    @Override
    public ContactRepository getRepository() {
        return null;
    }
}
