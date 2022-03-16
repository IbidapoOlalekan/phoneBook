package africa.semicolon.phoneBook.dtos.responses;

import africa.semicolon.phoneBook.data.models.Contact;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FindUserResponse {
    private String fullName;
    private String mobileNumber;

    public FindUserResponse(Contact contact){
        fullName = contact.getFirstName() + " " + contact.getLastName();
        mobileNumber = contact.getMobile();
    }

    public FindUserResponse(){

    }
}
