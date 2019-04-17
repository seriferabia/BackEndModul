package at.nacs.magic8ball.view;

import at.nacs.magic8ball.view.controller.MessagePicker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class Magic8MessagesController {
  private final MessagePicker picker;

  @ModelAttribute("message")
  String message() {
    return picker.getMessage();
  }

  @GetMapping
  String page() {
    return "magic8-message";
  }
}
