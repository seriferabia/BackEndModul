package at.nacs.magic8ball.view.controller;

import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@ConfigurationProperties("magic8")
public class MessagePicker {

  @Setter
  private List<String> messages;

  public String getMessage() {
    int randomIndex = new Random().nextInt(messages.size());
    return messages.get(randomIndex);
  }


}
