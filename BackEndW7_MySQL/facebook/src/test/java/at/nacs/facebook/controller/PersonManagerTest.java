package at.nacs.facebook.controller;

import at.nacs.facebook.persistence.Person;
import at.nacs.facebook.persistence.PersonRepository;
import lombok.Setter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("data")
class PersonManagerTest {
    @Autowired
    PersonManager manager;

    @Autowired
    PersonRepository repository;

    @Setter
    List<Person> persons;

    @Setter
    Person special;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.saveAll(persons);
    }


    @Test
    void getAll() {
        int actualSize = manager.getAll().size();
        assertThat(actualSize).isEqualTo(2);

    }

    @Test
    void save() {
        Person person = manager.save(special);
        assertThat(person.getId()).isNotNull();
    }

    @Test
    void getPersonsWithFriend() {
        int actualSize = manager.getPersonsWithFriend().size();
        assertThat(actualSize).isEqualTo(0);
    }

    @Test
    void getPersonsWithoutFriend() {
        int actualSize = manager.getPersonsWithoutFriend().size();
        assertThat(actualSize).isEqualTo(2);

    }

    @Test
    void connectFriends() {
        Long id1 = manager.getAll().get(0).getId();
        Long id2 = manager.getAll().get(1).getId();
        manager.connect(id1,id2);
        assertThat(manager.getAll().get(0).getFriends()).contains(manager.getAll().get(1));
        assertThat(manager.getAll().get(1).getFriends()).contains(manager.getAll().get(0));
        System.out.println(manager.getAll().get(0).getFriends());
        System.out.println(manager.getAll().get(1).getFriends());
    }

    @Test
    void disconnectFriends() {
        Long id1 = manager.getAll().get(0).getId();
        Long id2 = manager.getAll().get(1).getId();
        manager.connect(id1,id2);
        manager.disconnect(id1,id2);
        assertThat(manager.getAll().get(0).getFriends()).doesNotContain(manager.getAll().get(1));
        assertThat(manager.getAll().get(1).getFriends()).doesNotContain(manager.getAll().get(0));


    }
}