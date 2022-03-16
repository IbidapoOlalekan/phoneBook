package africa.semicolon.phoneBook.controller;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import africa.semicolon.phoneBook.services.AddContactService;
import africa.semicolon.phoneBook.services.AddContactServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private AddContactService addContactService ;

    @PostMapping("/register")
    public AddContactResponse addNewContact(@RequestBody AddContactRequest requests){
        return addContactService.save(requests);
    }

    @DeleteMapping("/delete")
    public void deleteContact(@RequestBody AddContactRequest requests){
        addContactService.delete(requests);
    }

    @GetMapping("/{keyword}")
    public List<FindUserResponse> findUserByName(@PathVariable ("keyword") String name){return addContactService.findUserByName(name);}
//
    @GetMapping("/{mobile}")
    public FindUserResponse findUserByMobile(@PathVariable String mobile){return addContactService.findUserByMobile(mobile);}
}
