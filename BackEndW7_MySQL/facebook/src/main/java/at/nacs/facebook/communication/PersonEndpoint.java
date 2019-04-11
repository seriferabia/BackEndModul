package at.nacs.facebook.communication;

import at.nacs.facebook.controller.PersonManager;
import at.nacs.facebook.persistence.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonEndpoint {
    private final PersonManager manager;

    @GetMapping
    List<Person> get() {
        return manager.getAll();
    }

    @PostMapping
    Person post(@RequestBody Person person) {
        return manager.save(person);
    }

    @GetMapping("/friends/with")
    List<Person> getSocials() {
        return manager.getPersonsWithFriend();
    }

    @GetMapping("/friends/without")
    List<Person> getLoners() {
        return manager.getPersonsWithoutFriend();
    }

    @PutMapping("/{id1}/friend/{id2}")
    void addAsFriend(@PathVariable Long id1, @PathVariable Long id2) {
        manager.connect(id1, id2);
    }

    @PutMapping("/{id1}/unfriend/{id2}")
    void deleteFriend(@PathVariable Long id1, @PathVariable Long id2) {
        manager.disconnect(id1, id2);
    }

}
