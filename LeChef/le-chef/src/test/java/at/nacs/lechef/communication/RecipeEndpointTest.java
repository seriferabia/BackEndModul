package at.nacs.lechef.communication;

import at.nacs.lechef.logic.RecipeManager;
import at.nacs.lechef.persistence.Recipe;
import at.nacs.lechef.persistence.RecipeRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("testdata")
class RecipeEndpointTest {

  @Autowired
  TestRestTemplate testRestTemplate;

  @MockBean
  RecipeRepository repository;

  @SpyBean
  RecipeManager manager;

  private String url = "/recipes";

  @Setter
  @Getter
  private Recipe recipe;


  @Test
  void testGet() {
    testRestTemplate.getForObject(url, Recipe[].class);
    verify(manager).findAll();
  }

  @Test
  void testPost() {
    testRestTemplate.postForObject(url, recipe, Recipe.class);
    verify(manager).save(any());
  }

  @Test
  void testGetByType() {
    testRestTemplate.getForObject(url + "/type/any", Recipe[].class);
    verify(manager).getByType(any());
  }

  @Test
  void getByLabel() {
    testRestTemplate.getForObject(url + "/label/any", Recipe[].class);
    verify(manager).getByLabel(any());
  }

  @Test
  void getByOrigin() {
    testRestTemplate.getForObject(url + "/origin/any", Recipe[].class);
    verify(manager).getByOrigin(any());
  }
}