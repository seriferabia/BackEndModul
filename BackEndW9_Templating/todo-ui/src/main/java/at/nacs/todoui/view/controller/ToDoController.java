package at.nacs.todoui.view.controller;

import at.nacs.todoui.view.logic.ToDoClient;
import at.nacs.todoui.view.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class ToDoController {
  private final ToDoClient toDoClient;

  @ModelAttribute("toDo")
  ToDo toDo() {
    return new ToDo();
  }

  @ModelAttribute("toDos")
  List<ToDo> toDos() {
    return toDoClient.allToDos();
  }

  @GetMapping
  String page() {
    return "todos";
  }

  @PostMapping
  String post(@Valid ToDo todo, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    toDoClient.save(todo);
    return "redirect:/";
  }

  @PostMapping("/done")
  String markAsDone(@RequestParam String id) {
    toDoClient.markAsDone(id);
    return "redirect:/";
  }

  @PostMapping("/delete")
  String delete(@RequestParam String id) {
    toDoClient.delete(id);
    return "redirect:/";
  }
}
