package at.nacs.templatingexample.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message/simple2")
public class SimpleMessage2Controller {

  @GetMapping
  String page(Model model) {
    model.addAttribute("message", "This message from the Model of the Controller");
    return "messages/simple-message2";
  }


}
