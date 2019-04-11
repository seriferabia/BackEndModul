package at.nacs.todo.logic;

import at.nacs.todo.persistence.ToDo;
import at.nacs.todo.persistence.ToDoRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
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
class ToDoManagerTest2 {
    @Autowired
    ToDoManager toDoManager;

    @Autowired
    ToDoRepository repository;

    @Setter
    List<ToDo> todos;

    @Setter
    ToDo special;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.saveAll(todos);
    }

    @Test
    void getAll() {
        List<ToDo> actual = toDoManager.getAll();
        assertThat(actual.size()).isEqualTo(3);
    }

    @Test
    void testSave() {
        ToDo toDo = toDoManager.save(special);
        assertThat(toDo.getId()).isNotEmpty();
        assertThat(toDoManager.getAll().size()).isEqualTo(4);
    }

    @Test
    void testGetOneWithId() {
        ToDo toDo = toDoManager.getAll().get(0);
        String id = toDo.getId();
        Optional<ToDo> oneWithId = toDoManager.getOne(id);
        assertThat(oneWithId.get()).isEqualTo(toDo);
    }

    @Test
    void testUpdateOne() {
        ToDo toDo = toDoManager.getAll().get(0);
        Optional<ToDo> done = toDoManager.updateOne(toDo.getId());
        assertThat(done.get().isDone()).isEqualTo(true);
    }
}