package africa.semicolon.phoneBook.data.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
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
