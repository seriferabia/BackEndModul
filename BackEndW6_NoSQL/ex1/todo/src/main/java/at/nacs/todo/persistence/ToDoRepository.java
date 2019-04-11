package at.nacs.todo.persistence;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;

@Configuration
public interface ToDoRepository extends MongoRepository<ToDo, String> {
}
