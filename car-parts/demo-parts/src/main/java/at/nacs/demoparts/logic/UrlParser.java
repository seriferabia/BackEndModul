package at.nacs.demoparts.logic;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class UrlParser {

  @Value("${carparts.url}")
  String url;

  public String buildUrl(String title) {
    UriComponents newUrl = UriComponentsBuilder
        .fromHttpUrl(url)
        .buildAndExpand(title);
    return newUrl.toString();
  }
}
