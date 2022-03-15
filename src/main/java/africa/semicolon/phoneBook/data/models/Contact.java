package africa.semicolon.phoneBook.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@Document("Contacts")
public class Contact {
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
