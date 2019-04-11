package at.nacs.todo.communication;

import at.nacs.todo.logic.ToDoManager;
import at.nacs.todo.persistence.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class ToDoEndpoint {
    private final ToDoManager toDoManager;

    @GetMapping
    List<ToDo> get(){
        return toDoManager.getAll();
    }

    @PostMapping
    ToDo post(@RequestBody ToDo toDo){
        return toDoManager.save(toDo);
    }

    @GetMapping("/{id}")
    Optional<ToDo> get(@PathVariable String id){
        return toDoManager.getOne(id);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable String id){
        toDoManager.deleteOne(id);
    }

    @PutMapping("/{id}/done")
    Optional<ToDo> put(@PathVariable String id){
        return toDoManager.updateOne(id);
    }
}
