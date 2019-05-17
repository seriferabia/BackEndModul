package at.nacs.userregistration.controller;

import at.nacs.userregistration.persistence.model.ConfirmationToken;
import at.nacs.userregistration.persistence.model.User;
import at.nacs.userregistration.persistence.repository.ConfirmationTokenRepository;
import at.nacs.userregistration.persistence.repository.UserRepository;
import at.nacs.userregistration.service.EmailSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/register")
@RequiredArgsConstructor
public class UserAccountController {
  private final UserRepository userRepository;
  private final ConfirmationTokenRepository confirmationTokenRepository;
  private final EmailSenderService emailService;

  @GetMapping
  public ModelAndView displayRegistration(ModelAndView modelAndView, User user) {
    modelAndView.addObject("user", user);
    modelAndView.setViewName("register");
    return modelAndView;
  }

  @PostMapping
  public ModelAndView registerUser(ModelAndView modelAndView, User user) {
    User existingUser = userRepository.findByEmail(user.getEmail());
    if (existingUser != null) {
      modelAndView.addObject("message", "This email already exists!");
      modelAndView.setViewName("error");
    } else {
      userRepository.save(user);
      ConfirmationToken confirmationToken = ConfirmationToken.builder()
                                                             .user(user)
                                                             .build();
      confirmationTokenRepository.save(confirmationToken);

      SimpleMailMessage mailMessage = new SimpleMailMessage();
      mailMessage.setTo(user.getEmail());
      mailMessage.setSubject("Complete Registration");
      mailMessage.setFrom("testspring456@gmail.com");
      mailMessage.setText("To confirm your account, please click here : "
          + "http://localhost:8082/register/confirmation?token=" + confirmationToken.getConfirmationToken());
      emailService.sendEmail(mailMessage);

      modelAndView.addObject("email", user.getEmail());
      modelAndView.setViewName("successfulRegistration");
    }
    return modelAndView;
  }

  @GetMapping("/confirmation")
  public ModelAndView confirmUserAccount(ModelAndView modelAndView, @RequestParam String token) {
    ConfirmationToken confirmationToken = confirmationTokenRepository.findByConfirmationToken(token);
    if (confirmationToken != null) {
      User user = userRepository.findByEmail(confirmationToken.getUser().getEmail());
      user.setEnabled(true);
      userRepository.save(user);
      modelAndView.setViewName("accountVerified");
    } else {
      modelAndView.addObject("message", "The link is broken!");
      modelAndView.setViewName("error");
    }
    return modelAndView;
  }
}
