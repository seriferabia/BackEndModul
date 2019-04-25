package at.nacs.lechef.logic;

import at.nacs.lechef.persistence.Ingredient;
import at.nacs.lechef.persistence.IngredientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientManager {
  private final IngredientRepository repository;

  public List<Ingredient> findAll() {
    return repository.findAll();
  }

  public Ingredient save(Ingredient ingredient) {
    return repository.save(ingredient);
  }

  public void delete(Long id) {
    Optional<Ingredient> ingredient = repository.findById(id);
    ingredient.ifPresent(e -> repository.deleteById(e.getId()));
  }

  public void updateAmount(Long id, Double newAmount) {
    Optional<Ingredient> ingredient = repository.findById(id);
    ingredient.ifPresent(e -> {
      e.setAmount(newAmount);
      repository.save(e);
    });
  }

}
