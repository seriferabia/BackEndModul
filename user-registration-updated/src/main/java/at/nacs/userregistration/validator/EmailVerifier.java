package at.nacs.userregistration.validator;

import at.nacs.userregistration.persistence.repository.UserRepository;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class EmailVerifier implements ConstraintValidator<ValidEmail, String> {

  private UserRepository userRepository;

  @Override
  public void initialize(ValidEmail user) {
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    return email != null && !userRepository.existsByEmail(email);
  }
}
