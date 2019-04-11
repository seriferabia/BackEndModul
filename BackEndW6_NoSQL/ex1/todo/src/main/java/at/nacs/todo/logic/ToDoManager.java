package at.nacs.todo.logic;

import at.nacs.todo.persistence.ToDo;
import at.nacs.todo.persistence.ToDoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ToDoManager {

    private final ToDoRepository toDoRepository;

    public List<ToDo> getAll() {
        return toDoRepository.findAll();
    }

    public ToDo save(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public Optional<ToDo> getOne(String id) {
        return toDoRepository.findById(id);
    }

    public void deleteOne(String id) {
        toDoRepository.deleteById(id);
    }

    public Optional<ToDo> updateOne(String id) {
        boolean isExist = toDoRepository.existsById(id);
        if (isExist){
            ToDo toDo = toDoRepository.findById(id).get();
            toDo.setDone(true);
            toDoRepository.save(toDo);
            return Optional.of(toDo);
        }
        return Optional.empty();
    }

}
