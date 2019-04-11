package at.nacs.todo.persistence;

import lombok.Data;

@Data
public class ToDo {

    private String id;
    private String title;
    private boolean done;
}
