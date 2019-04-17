package at.nacs.encoderui.view.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

@Controller
@RequiredArgsConstructor
public class EncoderClient {
  private final RestTemplate restTemplate;

  @Value("${encoder.url}")
  private String url;

  public String getEncodedMessage(String text) {
    return restTemplate.postForObject(url, text, String.class);
  }


}
