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
    public ResponseEntity<?> addNewContact(@RequestBody AddContactRequest requests){
        try {
            return new ResponseEntity<>(addContactService.save(CaseUtil.filter(requests)), HttpStatus.CREATED);
        }
        catch (RuntimeException e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()), HttpStatus.FOUND);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteContact(@RequestBody AddContactRequest requests){
        try {
            addContactService.delete(requests);
            return new ResponseEntity<>(new ApiResponse(true,"Deleted Successfully"),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(false,e.getMessage()),HttpStatus.BAD_REQUEST);
        }

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
