package at.nacs.thymeleafsecurity.view.advice;

import at.nacs.thymeleafsecurity.persistence.domain.User;
import at.nacs.thymeleafsecurity.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = "at.nacs.thymeleafsecurity.view.controller")
public class UserControllerAdvice {
  @ModelAttribute("user")
  User user(@AuthenticationPrincipal UserPrincipal principal) {
    if (isNotLoggedIn(principal)) {
      return null;
    }
    return principal.getUser();
  }

  private boolean isNotLoggedIn(UserPrincipal principal) {
    return principal == null;
  }
}
