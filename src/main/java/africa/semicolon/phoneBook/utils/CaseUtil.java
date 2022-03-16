package africa.semicolon.phoneBook.utils;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;

public class CaseUtil {
    public static AddContactRequest filter(AddContactRequest addContactRequest) {
        addContactRequest.setFirstName(convert(addContactRequest.getFirstName()));
        addContactRequest.setLastName(convert(addContactRequest.getLastName()));
        return addContactRequest;
    }

    private static String convert(String string) {
        return Character.toUpperCase(string.charAt(0)) + (string.substring(1)).toLowerCase();
    }
}
