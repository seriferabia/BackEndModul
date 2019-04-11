package at.nacs.facebook.communication;

import at.nacs.facebook.controller.PersonManager;
import at.nacs.facebook.persistence.Person;
import at.nacs.facebook.persistence.PersonRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("data")
class PersonEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @SpyBean
    PersonManager manager;

    @MockBean
    PersonRepository repository;

    @Setter
    Person special;

    String url = "/persons";

    @Test
    void get() {
        testRestTemplate.getForObject(url,Person[].class);
        verify(manager).getAll();
    }

    @Test
    void post() {
        testRestTemplate.postForObject(url,special, Person.class);
        verify(manager).save(any());
    }

    @Test
    void getSocials() {
        String newUrl = url + "/friends/with";
        testRestTemplate.getForObject(newUrl,Person[].class);
        verify(manager).getPersonsWithFriend();
    }

    @Test
    void getLoners() {
        String newUrl = url + "/friends/without";
        testRestTemplate.getForObject(newUrl,Person[].class);
        verify(manager).getPersonsWithoutFriend();
    }

    @Test
    void addAsFriend() {
        String newUrl = url + "/1/friend/2";
        testRestTemplate.put(newUrl, void.class);
        verify(manager).connect(anyLong(),anyLong());
    }

    @Test
    void deleteFriend() {
        String newUrl = url + "/1/unfriend/2";
        testRestTemplate.put(newUrl, void.class);
        verify(manager).disconnect(anyLong(),anyLong());
    }
}