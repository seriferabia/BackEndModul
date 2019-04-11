package at.nacs.facebook.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findById(Long id);

    List<Person> findAllByFriendsIsNotNull();

    List<Person> findAllByFriends_Empty();

}
