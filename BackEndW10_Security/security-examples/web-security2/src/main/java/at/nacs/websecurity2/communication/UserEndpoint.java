package at.nacs.websecurity2.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/user")
public class UserEndpoint {

  @GetMapping
  @RolesAllowed("USER")
  String message() {
    return "Message for only user";
  }
}
