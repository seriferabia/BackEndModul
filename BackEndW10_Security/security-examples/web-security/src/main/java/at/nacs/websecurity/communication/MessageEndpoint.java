package at.nacs.websecurity.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MessageEndpoint {

  @GetMapping
  String message() {
    return "First Protected Message With Spring Security Modul";
  }
}
