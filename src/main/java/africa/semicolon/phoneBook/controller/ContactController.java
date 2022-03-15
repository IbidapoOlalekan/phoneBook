package africa.semicolon.phoneBook.controller;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import africa.semicolon.phoneBook.services.AddContactService;
import africa.semicolon.phoneBook.services.AddContactServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contact")
public class ContactController {
     AddContactService addContactService = new AddContactServiceImpl();

    @PostMapping("/register")
    public AddContactResponse addNewContact(@RequestBody AddContactRequest requests){
        return addContactService.save(requests);
    }

    @DeleteMapping("/{contact}")
    public void deleteContact(@RequestBody AddContactRequest requests){
        addContactService.delete(requests);
    }

    @GetMapping("/{name}")
    public FindUserResponse findUserByName(@PathVariable String name){return addContactService.findUserByName(name);}
//
//    @GetMapping("/{mobile}")
//    public FindUserResponse findUserByMobile(@PathVariable String mobile){return addContactService.findUserByMobile(mobile);}
}
