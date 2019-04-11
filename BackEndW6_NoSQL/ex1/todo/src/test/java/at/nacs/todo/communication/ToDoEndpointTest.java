package at.nacs.todo.communication;

import at.nacs.todo.logic.ToDoManager;
import at.nacs.todo.persistence.ToDo;
import at.nacs.todo.persistence.ToDoRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset2")
class ToDoEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    ToDo todo;

    @SpyBean
    ToDoManager toDoManager;

    @MockBean
    ToDoRepository repository;


    @Test
    void get() {
        testRestTemplate.getForObject("/todos", ToDo[].class);
        verify(toDoManager).getAll();

    }

    @Test
    void post() {
        testRestTemplate.postForObject("/todos", todo, ToDo.class);
        verify(toDoManager).save(any());
    }

    @Test
    void getOneWithId() {
        testRestTemplate.getForObject("/todos/anyId", ToDo.class);
        verify(toDoManager).getOne(anyString());
    }

    @Test
    void deleteWithId() {
        testRestTemplate.delete("/todos/anyId");
        verify(toDoManager).deleteOne(anyString());
    }

    @Test
    void put() {
        String urlIdDone = "/todos/anyId/done";
        testRestTemplate.put(urlIdDone, true);
        verify(toDoManager).updateOne(anyString());
    }
}