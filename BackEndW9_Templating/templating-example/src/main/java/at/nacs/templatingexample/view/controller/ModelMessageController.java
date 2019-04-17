package at.nacs.templatingexample.view.controller;

import at.nacs.templatingexample.view.model.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/message/model")
public class ModelMessageController {

  @ModelAttribute("message")
  Message message() {
    return Message.builder()
                  .text("This message from the View Controller's Model ( used Message class )")
                  .build();
  }

  @GetMapping
  String page() {
    return "messages/model-message";
  }
}
