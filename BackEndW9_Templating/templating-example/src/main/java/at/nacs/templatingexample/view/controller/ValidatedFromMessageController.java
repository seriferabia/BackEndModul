package at.nacs.templatingexample.view.controller;

import at.nacs.templatingexample.view.model.ValidatedMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/message/form/validated")
public class ValidatedFromMessageController {
  private ValidatedMessage message = new ValidatedMessage();

  @ModelAttribute
  ValidatedMessage validatedMessage() {
    return message;
  }

  @GetMapping
  String page() {
    return "messages/validated-form-message";
  }

  @PostMapping
  String post(@Valid ValidatedMessage validatedMessage, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    message = validatedMessage;
    return "redirect:/message/form/validated";
  }
}
