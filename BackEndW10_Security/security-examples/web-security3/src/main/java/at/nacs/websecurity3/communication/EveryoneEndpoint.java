package at.nacs.websecurity3.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class EveryoneEndpoint {
  @GetMapping
  String message() {
    return "Message for everyone";
  }
}
