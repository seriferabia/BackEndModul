package at.nacs.lechef.communication;

import at.nacs.lechef.logic.IngredientManager;
import at.nacs.lechef.persistence.Ingredient;
import at.nacs.lechef.persistence.IngredientRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("testdata2")
class IngredientEndpointTest {
  @Autowired
  TestRestTemplate testRestTemplate;

  @MockBean
  IngredientRepository repository;

  @SpyBean
  IngredientManager manager;

  @Setter
  @Getter
  private Ingredient ingredient;

  private String url = "/ingredients";

  @Test
  void get() {
    testRestTemplate.getForObject(url, Ingredient[].class);
    verify(manager).findAll();
  }

  @Test
  void post() {
    testRestTemplate.postForObject(url, ingredient, Ingredient.class);
    verify(manager).save(any());
  }

  @Test
  void put() {
    testRestTemplate.put(url + "/id/2/amount/5", Void.class);
    verify(manager).updateAmount(anyLong(), anyDouble());
  }

  @Test
  void delete() {
    testRestTemplate.delete(url + "/delete/2");
    verify(manager).delete(anyLong());
  }
}