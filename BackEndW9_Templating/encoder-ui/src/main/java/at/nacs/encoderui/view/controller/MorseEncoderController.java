package at.nacs.encoderui.view.controller;

import at.nacs.encoderui.view.logic.EncoderClient;
import at.nacs.encoderui.view.model.Plaintext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MorseEncoderController {
  private final EncoderClient client;

  private Plaintext plaintext = new Plaintext();

  @ModelAttribute("plaintext")
  Plaintext plaintext() {
    return plaintext;
  }

  @GetMapping
  String page() {
    return "morse-encoder";
  }

  @PostMapping
  String post(@Valid Plaintext plaintext, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    String encodedMessage = client.getEncodedMessage(plaintext.getText());
    plaintext.setText(encodedMessage);
    return "redirect:/";
  }
}
