package at.nacs.phonebook.communication;

import at.nacs.phonebook.controller.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactEndpoint {
    private final ContactManager manager;

    @GetMapping
    List<Contact> get(){
        return manager.getAll();
    }

    @PostMapping
    Contact post(@RequestBody Contact contact){
        return manager.post(contact);
    }

    @GetMapping("/address/{addressName}")
    List<Contact> get(@PathVariable String addressName){
        return manager.getByAddress(addressName);
    }
}
