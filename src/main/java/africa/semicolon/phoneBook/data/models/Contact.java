package africa.semicolon.phoneBook.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Document("Contacts")
public class Contact {
   @ Id
    private String id;


    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String middleName;
    @NonNull
    //the nonnull affects the field right below it
    private String mobile;
    private String office;
}
