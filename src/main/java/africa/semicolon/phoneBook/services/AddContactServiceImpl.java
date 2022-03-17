package africa.semicolon.phoneBook.services;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.data.repositories.ContactRepository;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import africa.semicolon.phoneBook.exceptions.ContactNotFoundException;
import africa.semicolon.phoneBook.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddContactServiceImpl implements AddContactService{
    @Autowired
    private ContactRepository contactRepository;


    @Override
    public AddContactResponse save(AddContactRequest requests) {

            Contact contact = ModelMapper.map(requests);
            Contact savedContact = contactRepository.save(contact);
            return ModelMapper.map(savedContact);
    }

    @Override
    public ContactRepository getRepository() {
        return contactRepository;
    }

    private List<Contact> findContactByFirstNameOrLastName(String name){
        List<Contact> contacts = new ArrayList<>();
        contacts.addAll(contactRepository.findContactByFirstName(name));
        contacts.addAll(contactRepository.findContactByLastName(name));
        return contacts;
    }

    @Override
    public List<FindUserResponse> findUserByName(String name) {
        List<Contact> contacts  = findContactByFirstNameOrLastName(name);
        if (contacts.isEmpty()) throw new ContactNotFoundException(name + " not found");
        List <FindUserResponse> responses = new ArrayList<>();
        contacts.forEach(contact-> {
            responses.add(new FindUserResponse(contact));
            responses.add(ModelMapper.contactToFindContactResponse(contact));
        });
      return responses;
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
