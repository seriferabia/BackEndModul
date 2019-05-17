package at.nacs.userregistration.persistence.repository;

import at.nacs.userregistration.persistence.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
  User findByEmail(String email);
  boolean existsByEmail(String email);
}
