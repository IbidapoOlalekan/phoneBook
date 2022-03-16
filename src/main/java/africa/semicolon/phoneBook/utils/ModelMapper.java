package africa.semicolon.phoneBook.utils;

import africa.semicolon.phoneBook.data.models.Contact;
import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;

public class ModelMapper {
    public static Contact map(AddContactRequest requests){
        Contact contact = new Contact();
        contact.setFirstName(requests.getFirstName());
        contact.setLastName(requests.getLastName());
        contact.setMobile(requests.getMobile());
        return contact;
    }

    public static AddContactResponse map(Contact theContact){
        AddContactResponse response = new AddContactResponse();
        response.setFullName(theContact.getFirstName() + " " + theContact.getLastName());
        response.setMobile(theContact.getMobile());
        return response;
    }

    public static FindUserResponse contactToFindContactResponse(Contact contact){
        FindUserResponse response = new FindUserResponse();

        response.setFullName(contact.getFirstName() + " " + contact.getLastName());
        response.setMobileNumber(contact.getMobile());
        return  response;
    }
}
