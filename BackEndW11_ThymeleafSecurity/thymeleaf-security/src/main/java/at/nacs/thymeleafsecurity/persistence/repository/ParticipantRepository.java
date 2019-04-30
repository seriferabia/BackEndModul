package at.nacs.thymeleafsecurity.persistence.repository;

import at.nacs.thymeleafsecurity.persistence.domain.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
