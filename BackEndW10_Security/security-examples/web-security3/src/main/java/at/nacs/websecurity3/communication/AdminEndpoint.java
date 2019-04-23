package at.nacs.websecurity3.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RequestMapping("/admin")
public class AdminEndpoint {
  @GetMapping
  @RolesAllowed("ADMIN")
  String message() {
    return "Message for only admin";
  }
}
