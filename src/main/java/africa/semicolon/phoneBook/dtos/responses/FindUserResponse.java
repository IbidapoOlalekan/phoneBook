package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FindUserResponse {
    private String fullName;
    private String mobileNumber;
}
