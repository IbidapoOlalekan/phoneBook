package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddContactResponse {
    private String fullName;
    private String mobile;
}
