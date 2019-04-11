package at.nacs.todo.logic;

import at.nacs.todo.persistence.ToDo;
import at.nacs.todo.persistence.ToDoRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class ToDoManagerTest {
    @Autowired
    ToDoManager toDoManager;

    @Setter
    List<ToDo> todos;


    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,2",
            "2,3"
    })
    void testSave(Integer position, Integer expectedSize) {
        ToDo toDo = toDoManager.save(todos.get(position));
        assertThat(toDo.getId()).isNotEmpty();
        int actualSize = toDoManager.getAll().size();
        assertThat(actualSize).isEqualTo(expectedSize);
    }

    @Test
    void testGetOneWithId() {
        ToDo toDo = toDoManager.save(todos.get(0));
        String id = toDo.getId();
        Optional<ToDo> oneWithId = toDoManager.getOne(id);
        assertThat(oneWithId.get()).isEqualTo(toDo);
    }

    @Test
    void testUpdateOne() {
        ToDo toDo = toDoManager.save(todos.get(0));
        Optional<ToDo> done = toDoManager.updateOne(toDo.getId());
        assertThat(done.get().isDone()).isEqualTo(true);
        System.out.println(toDoManager.getAll().size());

    }
}