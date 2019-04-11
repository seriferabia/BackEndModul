package at.nacs.facebook.controller;

import at.nacs.facebook.persistence.Person;
import at.nacs.facebook.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class PersonManager {
    private final PersonRepository repository;
    private final ContactManager manager;

    public List<Person> getAll() {
        return repository.findAll();
    }

    public List<Person> getPersonsWithFriend() {
//        List<Person> persons = repository.findAll();
//        return persons.stream()
//                .filter(person -> !person.getFriends().isEmpty())
//                .collect(toList());
        return repository.findAllByFriendsIsNotNull();
    }

    public List<Person> getPersonsWithoutFriend() {
        return repository.findAllByFriends_Empty();
    }

    public Person save(Person person) {
        return repository.save(person);
    }

    public void connect(Long id1, Long id2) {
        manager.connectFriends(id1, id2);
    }

    public void disconnect(Long id1, Long id2) {
        manager.disconnectFriends(id1, id2);
    }

}
