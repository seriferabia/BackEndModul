package at.nacs.userregistration.persistence.repository;

import at.nacs.userregistration.persistence.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Long> {
  ConfirmationToken findByConfirmationToken(String confirmationToken);
}
