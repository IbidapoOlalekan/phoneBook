package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import africa.semicolon.phoneBook.exceptions.ContactNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class AddContactServiceImpl implements AddContactService{
    @Autowired
    ContactRepository contactRepository;
    @Override
    public AddContactResponse save(AddContactRequest requests) {
            Contact contact = new Contact(requests.getFirstName(),requests.getLastName(),requests.getMobile());
            Contact savedContact = contactRepository.save(contact);
            AddContactResponse response = new AddContactResponse();
            response.setFullName(savedContact.getFirstName() + " " + savedContact.getLastName());
            response.setMobile(savedContact.getMobile());

;        return response;
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    @Override
    public FindUserResponse findUserByName(String name) {
        name = name.toLowerCase();
        Contact contact  = contactRepository.findContactByFirstNameOrLastName(name);
        if (contact == null) throw new ContactNotFoundException(name + "not found");

        FindUserResponse response = new FindUserResponse();
        response.setFullName(contact.getFirstName() +" " + contact.getLastName());
        response.setMobileNumber(contact.getMobile());
        return response;
    }

    @Override
    public void delete(AddContactRequest requests) {
        Contact contact = new Contact(requests.getFirstName(), requests.getLastName(), requests.getMobile());
        contactRepository.delete(contact);
    }

    @Override
    public FindUserResponse findUserByMobile(String mobile) {
        Contact contact = contactRepository.findContactByMobile(mobile);
        if (contact == null) throw new ContactNotFoundException(mobile + " not found");

        FindUserResponse response = new FindUserResponse();
        response.setMobileNumber(contact.getMobile());
        response.setFullName(contact.getFirstName() + " " + contact.getLastName());
        return response;
    }
}
