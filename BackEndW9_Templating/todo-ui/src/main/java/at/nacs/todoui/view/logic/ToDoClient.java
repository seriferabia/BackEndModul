package at.nacs.todoui.view.logic;

import at.nacs.todoui.view.model.ToDo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ToDoClient {
  private final RestTemplate restTemplate;

  @Value("${todo.url}")
  private String url;

  public List<ToDo> allToDos() {
    ToDo[] toDos = restTemplate.getForObject(url, ToDo[].class);
    return new ArrayList<>(Arrays.asList(toDos));

  }

  public ToDo save(ToDo toDo) {
    return restTemplate.postForObject(url, toDo, ToDo.class);
  }

  public void markAsDone(String id) {
    String doneUrl = url + "/" + id + "/done";
    restTemplate.put(doneUrl, ToDo.class);
  }

  public void delete(String id) {
    restTemplate.delete(url + "/" + id);
  }
}
