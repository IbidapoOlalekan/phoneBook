package africa.semicolon.phoneBook.controller;

import africa.semicolon.phoneBook.dtos.requests.AddContactRequest;
import africa.semicolon.phoneBook.dtos.responses.AddContactResponse;
import africa.semicolon.phoneBook.dtos.responses.ApiResponse;
import africa.semicolon.phoneBook.dtos.responses.FindUserResponse;
import africa.semicolon.phoneBook.exceptions.ContactNotFoundException;
import africa.semicolon.phoneBook.services.AddContactService;
import africa.semicolon.phoneBook.utils.CaseUtil;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private AddContactService addContactService ;

    @PostMapping("/register")
    public AddContactResponse addNewContact(@RequestBody AddContactRequest requests){
        return addContactService.save(CaseUtil.filter(requests));
    }

    @DeleteMapping("/delete")
    public void deleteContact(@RequestBody AddContactRequest requests){
        addContactService.delete(requests);
    }

    @GetMapping("/{keyword}")
    public ResponseEntity<?> findUserByName(@PathVariable ("keyword") String name){
        try {
            return new ResponseEntity<>(addContactService.findUserByName(name), HttpStatus.OK);
        }
        catch (ContactNotFoundException ex){
            return new ResponseEntity<>(new ApiResponse(false,ex.getMessage()), HttpStatus.NOT_FOUND);
        }

    }
//
//    @GetMapping("/{mobile}")
//    public FindUserResponse findUserByMobile(@PathVariable String mobile){return addContactService.findUserByMobile(mobile);}
}
