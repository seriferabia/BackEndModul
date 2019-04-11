package at.nacs.phonebook.controller;

import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("data")
class ContactManagerTest {

    @Autowired
    ContactManager manager;

    @Autowired
    ContactRepository repository;

    @Setter
    Contact contact1;

    @Setter
    Contact contact2;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.save(contact1);
    }

    @Test
    void getAll() {
        int actualSize = manager.getAll().size();
        assertThat(actualSize).isEqualTo(1);

    }

    @Test
    void post() {
        Contact postedContact = manager.post(contact2);
        assertThat(postedContact.getId()).isNotNull();
        assertThat(manager.getAll().size()).isEqualTo(2);
    }

    @Test
    void getByAddress() {
        List<Contact> contacts = manager.getByAddress("fake address");
        assertThat(contacts.get(0).getAddress().getName()).contains("fake");
        assertThat(contacts.get(0).getAddress().getName()).contains("address");
    }
}