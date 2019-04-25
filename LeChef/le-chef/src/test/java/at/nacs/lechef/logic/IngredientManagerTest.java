package at.nacs.lechef.logic;

import at.nacs.lechef.persistence.Ingredient;
import at.nacs.lechef.persistence.IngredientRepository;
import lombok.Getter;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("testdata2")
class IngredientManagerTest {
  @Autowired
  IngredientManager manager;

  @Autowired
  IngredientRepository repository;

  @Setter
  List<Ingredient> ingredients;

  @Setter
  @Getter
  Ingredient ingredient;

  @BeforeEach
  void setUp() {
    repository.deleteAll();
    repository.saveAll(ingredients);
  }

  @Test
  void testFindAll() {
    int actualSize = manager.findAll().size();
    assertThat(actualSize).isEqualTo(2);
  }

  @Test
  void testSave() {
    Ingredient savedIngredient = manager.save(ingredient);
    assertThat(savedIngredient.getId()).isNotNull();
  }

  @Test
  void delete() {
    Long id = manager.findAll().get(0).getId();
    manager.delete(id);
    int actualSize = manager.findAll().size();
    assertThat(actualSize).isEqualTo(1);
  }

  @Test
  void updateAmount() {
    assertThat(manager.findAll().get(0).getAmount()).isEqualTo(10.0);
    Long id = manager.findAll().get(0).getId();

    manager.updateAmount(id, 8.0);
    assertThat(manager.findAll().get(0).getAmount()).isEqualTo(8.0);
    assertThat(manager.findAll().get(0).getAmount()).isNotEqualTo(10.0);

  }
}