package at.nacs.templatingexample.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message/simple")
public class SimpleMessageController {

  @ModelAttribute("message")
  String message() {
    return "This message from view controller by ModelAttribute annotation ";
  }

  @GetMapping
  String page() {
    return "messages/simple-message";
  }

}
