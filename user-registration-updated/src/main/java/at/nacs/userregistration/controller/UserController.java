package at.nacs.userregistration.controller;

import at.nacs.userregistration.logic.MailParser;
import at.nacs.userregistration.persistence.model.ConfirmationToken;
import at.nacs.userregistration.persistence.model.User;
import at.nacs.userregistration.persistence.repository.ConfirmationTokenRepository;
import at.nacs.userregistration.persistence.repository.UserRepository;
import at.nacs.userregistration.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class UserController {
  private final UserRepository userRepository;
  private final ConfirmationTokenRepository confirmationTokenRepository;
  private final EmailSenderService emailService;
  private final MailParser mailParser;

  @ModelAttribute("user")
  User user() {
    return new User();
  }

  @ModelAttribute("message")
  String message() {
    return "This email already exists!";
  }

  @ModelAttribute("linkErrorMessage")
  String linkErrorMessage() {
    return "This link is broken!";
  }

  @GetMapping
  String page() {
    return "register";
  }

  @PostMapping
  String post(@Valid User user, BindingResult result) {
    if (result.hasErrors()) {
      return "error";
    }
    userRepository.save(user);
    ConfirmationToken confirmationToken = getToken(user);
    confirmationTokenRepository.save(confirmationToken);
    SimpleMailMessage mailMessage = mailParser.createMail(user, confirmationToken);
    emailService.sendEmail(mailMessage);
    return "successfulRegistration";
  }

  @GetMapping("/confirmation")
  String confirmUserAccount(@RequestParam String token) {
    ConfirmationToken confirmationToken = confirmationTokenRepository.findByConfirmationToken(token);
    if (confirmationToken == null) {
      return "linkerror";
    }
    User user = userRepository.findByEmail(confirmationToken.getUser().getEmail());
    user.setEnabled(true);
    userRepository.save(user);
    return "accountVerified";
  }

  private ConfirmationToken getToken(User user) {
    return ConfirmationToken.builder().user(user).build();
  }
}

