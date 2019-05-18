package at.nacs.userregistration.validator;

import at.nacs.userregistration.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Objects;

public class EmailVerifier implements ConstraintValidator<ValidEmail, String> {
  @Autowired
  private UserRepository userRepository;

  @Override
  public void initialize(ValidEmail email) {
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    return Objects.nonNull(email) && !userRepository.existsByEmail(email);
  }
}
