package at.nacs.secretorganization.view.advice;

import at.nacs.secretorganization.persistence.model.Member;
import at.nacs.secretorganization.security.UserPrincipal;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice(basePackages = "at.nacs.secretorganization.view.controller")
public class UserControllerAdvice {
  @ModelAttribute("member")
  Member member(@AuthenticationPrincipal UserPrincipal principal) {
    if (isNotLoggedIn(principal)) {
      return null;
    }
    return principal.getMember();
  }

  private boolean isNotLoggedIn(UserPrincipal principal) {
    return principal == null;
  }
}