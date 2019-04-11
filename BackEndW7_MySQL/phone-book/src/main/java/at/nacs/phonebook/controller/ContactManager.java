package at.nacs.phonebook.controller;

import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactManager {

    private final ContactRepository repository;

    public List<Contact> getAll() {
        return repository.findAll();
    }

    public Contact post(Contact contact) {
        return repository.save(contact);
    }

    public List<Contact> getByAddress(String name) {
        String address = "%" + name + "%";
        return repository.findAllByAddress_NameLike(address);
    }
}
