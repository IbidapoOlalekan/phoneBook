package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.data.repositories.ContactRepositoryImpl;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import africa.semicolon.phoneBook.exceptions.ContactNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AddContactServiceImpl implements AddContactService{
    ContactRepository contactRepository = new ContactRepositoryImpl();
    @Override
    public AddContactResponse save(AddContactRequest requests) {
            Contact contact = new Contact(requests.getFirstName(),requests.getLastName(),requests.getMobile());
            contactRepository.saveContact(contact);

;        return null;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public FindUserResponse findUserByName(String name) {
        name = name.toLowerCase();
        Contact contact  = contactRepository.findBy(name);
        if (contact == null) throw new ContactNotFoundException(name + "not found");

        FindUserResponse response = new FindUserResponse();
        response.setFullName(contact.getFirstName() +" " + contact.getLastName());
        return response;
    }

    @Override
    public void delete(AddContactRequest requests) {
        Contact contact = new Contact(requests.getFirstName(), requests.getLastName(), requests.getMobile());
        contactRepository.deleteContact(contact);
    }

    @Override
    public FindUserResponse findUserByMobile(String mobile) {
        Contact contact = contactRepository.findByNumber(mobile);
        if (contact == null) throw new ContactNotFoundException(mobile + " not found");

        FindUserResponse response = new FindUserResponse();
        response.setMobileNumber(contact.getMobile());
        return response;
    }
}
