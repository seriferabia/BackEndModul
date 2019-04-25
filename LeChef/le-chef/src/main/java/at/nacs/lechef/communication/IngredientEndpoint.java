package at.nacs.lechef.communication;

import at.nacs.lechef.logic.IngredientManager;
import at.nacs.lechef.persistence.Ingredient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientEndpoint {
  private final IngredientManager manager;

  @GetMapping
  List<Ingredient> get() {
    return manager.findAll();
  }

  @PostMapping
  Ingredient post(@RequestBody Ingredient ingredient) {
    return manager.save(ingredient);
  }

  @PutMapping("/id/{id}/amount/{newAmount}")
  void put(@PathVariable long id, @PathVariable double newAmount) {
    manager.updateAmount(id, newAmount);
  }

  @DeleteMapping("/delete/{id}")
  void delete(@PathVariable Long id) {
    manager.delete(id);
  }
}
