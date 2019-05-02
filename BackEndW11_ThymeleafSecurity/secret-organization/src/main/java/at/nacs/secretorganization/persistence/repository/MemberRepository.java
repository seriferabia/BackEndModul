package at.nacs.secretorganization.persistence.repository;

import at.nacs.secretorganization.persistence.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

  Optional<Member> findOneByUsername(String username);

  boolean existsByUsername(String username);
}
