package at.nacs.templatingexample.view.controller;

import at.nacs.templatingexample.view.model.DayOfTheWeek;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Controller
@RequestMapping("/daysoftheweek")
public class DaysOfTheWeekController {
  private List<DayOfTheWeek> days = Stream.of(
      "Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday".split(", "))
                                          .map(name -> new DayOfTheWeek(name))
                                          .collect(toList());

  @ModelAttribute("daysOfTheWeek")
  List<DayOfTheWeek> daysOfTheWeek() {
    return days;
  }

  @GetMapping
  String page() {
    return "day-of-the-week";
  }
}
