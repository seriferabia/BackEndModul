package at.nacs.templatingexample.view.controller;

import at.nacs.templatingexample.view.model.City;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cities")
public class CitiesController {

  private List<City> cities = new ArrayList<>();

  @ModelAttribute("cities")
  List<City> cities() {
    return cities;
  }

  @ModelAttribute("city")
  City city() {
    return new City();
  }

  @GetMapping
  String page() {
    return "cities";
  }

  @PostMapping
  String post(@Valid City city, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    cities.add(city);
    return "redirect:/cities";
  }

  @PostMapping("/delete")
  String delete(@RequestParam String name) {
    cities.removeIf(city -> city.getName().equals(name));
    return "redirect:/cities";
  }
}
