package at.nacs.phonebook.communication;

import at.nacs.phonebook.controller.ContactManager;
import at.nacs.phonebook.persistence.Contact;
import at.nacs.phonebook.persistence.ContactRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("data")
class ContactEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    Contact contact1;

    @SpyBean
    ContactManager manager;

    @MockBean
    ContactRepository repository;

    private String url = "/contacts/";


    @Test
    void testGet() {
        testRestTemplate.getForObject(url, Contact[].class);
        verify(manager).getAll();
    }

    @Test
    void testPost() {
        testRestTemplate.postForObject(url, contact1, Contact.class);
        verify(manager).post(any());
    }

    @Test
    void testGetByAddress() {
        String addressUrl = url + "address/any";
        testRestTemplate.getForObject(addressUrl, Contact[].class);
        verify(manager).getByAddress(anyString());
    }
}