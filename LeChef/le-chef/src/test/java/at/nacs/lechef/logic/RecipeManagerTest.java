package at.nacs.lechef.logic;

import at.nacs.lechef.persistence.Recipe;
import at.nacs.lechef.persistence.RecipeRepository;
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
@ConfigurationProperties("testdata")
class RecipeManagerTest {

  @Autowired
  RecipeManager manager;

  @Autowired
  RecipeRepository repository;

  @Setter
  List<Recipe> recipes;

  @Setter
  Recipe recipe;

  @BeforeEach
  void setUp() {
    repository.deleteAll();
    repository.saveAll(recipes);
  }

  @Test
  void findAll() {
    int actualSize = manager.findAll().size();
    assertThat(actualSize).isEqualTo(3);
  }

  @Test
  void save() {
    manager.save(recipe);
    assertThat(recipe.getId()).isNotNull();
  }

  @Test
  void getByType() {
    List<Recipe> actual = manager.getByType("dessert");
    assertThat(actual.get(0).getName()).isEqualTo("tramisu");
    assertThat(actual.get(0).getType()).isEqualTo("dessert");
  }

  @Test
  void getByLabel() {
    List<Recipe> actual = manager.getByLabel("spicy");
    assertThat(actual.get(0).getLabel()).isEqualTo("spicy");
    assertThat(actual.get(0).getName()).isEqualTo("doner");
  }

  @Test
  void getByOrigin() {
    List<Recipe> actual = manager.getByOrigin("turkey");
    assertThat(actual.get(0).getOrigin()).isEqualTo("turkey");
    assertThat(actual.get(0).getName()).isEqualTo("doner");
  }
}