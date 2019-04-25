package at.nacs.lechef.communication;

import at.nacs.lechef.logic.RecipeManager;
import at.nacs.lechef.persistence.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recipes")
@RequiredArgsConstructor
public class RecipeEndpoint {
  private final RecipeManager manager;

  @GetMapping
  List<Recipe> get() {
    return manager.findAll();
  }

  @PostMapping
  Recipe post(@RequestBody Recipe recipe) {
    return manager.save(recipe);
  }

  @GetMapping("/type/{type}")
  List<Recipe> getByType(@PathVariable String type) {
    return manager.getByType(type);
  }

  @GetMapping("/label/{label}")
  List<Recipe> getByLabel(@PathVariable String label) {
    return manager.getByLabel(label);
  }

  @GetMapping("/origin/{origin}")
  List<Recipe> getByOrigin(@PathVariable String origin) {
    return manager.getByOrigin(origin);
  }
}
