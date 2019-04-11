package at.nacs.facebook.controller;

import at.nacs.facebook.persistence.Person;
import at.nacs.facebook.persistence.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class ContactManager {
    private final PersonRepository repository;

    public void connectFriends(Long id1, Long id2) {
        Optional<Person> person1 = repository.findById(id1);
        Optional<Person> person2 = repository.findById(id2);
        makeFriend(person1, person2);
        makeFriend(person2, person1);

    }

    private void makeFriend(Optional<Person> person1, Optional<Person> person2) {
        if (person1.isPresent() & person2.isPresent()) {
            person1.get().getFriends().add(person2.get());
            repository.save(person1.get());
        }
    }

    public void disconnectFriends(Long id1, Long id2) {
        Optional<Person> person1 = repository.findById(id1);
        Optional<Person> person2 = repository.findById(id2);
        undoFriends(person1, person2);
        undoFriends(person2, person1);

    }

    private void undoFriends(Optional<Person> person1, Optional<Person> person2) {
        if (person1.isPresent() & person2.isPresent()) {
            person1.get().getFriends().removeIf(person -> person.equals(person2.get()));
            repository.save(person1.get());
        }
    }
}
