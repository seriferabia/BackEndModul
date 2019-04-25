package at.nacs.lechef.logic;

import at.nacs.lechef.persistence.Recipe;
import at.nacs.lechef.persistence.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeManager {
  private final RecipeRepository repository;

  public List<Recipe> findAll() {
    return repository.findAll();
  }

  public Recipe save(Recipe recipe) {
    return repository.save(recipe);
  }

  public List<Recipe> getByType(String type) {
    return repository.findAllByType(type);
  }

  public List<Recipe> getByLabel(String label) {
    return repository.findAllByLabel(label);
  }

  public List<Recipe> getByOrigin(String origin) {
    return repository.findAllByOrigin(origin);
  }
}
