package at.nacs.thievesden.communication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class DenEndpoint {

  @GetMapping
  String treasures() {
    return "All treasures";
  }

}
