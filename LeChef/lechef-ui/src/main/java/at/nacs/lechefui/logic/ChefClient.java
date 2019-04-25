package at.nacs.lechefui.logic;

import at.nacs.lechefui.domain.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ChefClient {
  private final RestTemplate restTemplate;

  @Value("${recipes.url}")
  private String url;

  public Recipe save(Recipe recipe) {
    return restTemplate.postForObject(url, recipe, Recipe.class);
  }
}
