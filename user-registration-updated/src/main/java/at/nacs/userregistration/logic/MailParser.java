package at.nacs.userregistration.logic;

import at.nacs.userregistration.persistence.model.ConfirmationToken;
import at.nacs.userregistration.persistence.model.User;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MailParser {
  public SimpleMailMessage createMail(User user, ConfirmationToken confirmationToken) {
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setTo(user.getEmail());
    mailMessage.setSubject("Complete Registration");
    mailMessage.setFrom("testspring456@gmail.com");
    mailMessage.setText("To confirm your account, please click here : "
        + "http://localhost:8082/register/confirmation?token=" + confirmationToken.getConfirmationToken());
    return mailMessage;
  }
}
