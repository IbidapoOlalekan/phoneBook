package africa.semicolon.phoneBook.dtos.responses;

import lombok.Data;

@Data
public class FindUserResponse {
    private String fullName;
    private String mobileNumber;
}
