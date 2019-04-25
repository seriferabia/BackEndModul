package at.nacs.lechefui;

import at.nacs.lechefui.domain.Ingredient;
import at.nacs.lechefui.domain.Recipe;
import at.nacs.lechefui.logic.ChefClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chef")
@RequiredArgsConstructor
public class ChefController {
  private final ChefClient client;
  private List<Ingredient> ingredients = new ArrayList<>();

  @ModelAttribute("ingredient")
  Ingredient ingredient() {
    return new Ingredient();
  }

  @ModelAttribute("ingredients")
  List<Ingredient> ingredients() {
    return ingredients;
  }

  @ModelAttribute("recipe")
  Recipe recipe() {
    return new Recipe();
  }

  @GetMapping
  String page() {
    return "chef";
  }

  @PostMapping("/ingredient")
  String postIngredientsForRecipe(@Valid Ingredient ingredient, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    ingredients.add(ingredient);
    return "redirect:/chef";
  }

  @PostMapping
  String post(@Valid Recipe recipe, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    recipe.setIngredients(ingredients);
    client.save(recipe);
    ingredients.clear();
    return "redirect:/chef";
  }
}
