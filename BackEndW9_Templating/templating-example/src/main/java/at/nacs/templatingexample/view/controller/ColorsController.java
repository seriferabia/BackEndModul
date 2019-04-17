package at.nacs.templatingexample.view.controller;

import at.nacs.templatingexample.view.model.Color;
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
@RequestMapping("/colors")
public class ColorsController {
  private List<Color> colors = new ArrayList<>();

  @ModelAttribute("colors")
  List<Color> colors() {
    return colors;
  }

  @ModelAttribute("color")
  Color color() {
    return new Color();
  }

  @GetMapping
  String page() {
    return "colors";
  }

  @PostMapping
  String post(@Valid Color color, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    colors.add(color);
    return "redirect:/colors";
  }
}
