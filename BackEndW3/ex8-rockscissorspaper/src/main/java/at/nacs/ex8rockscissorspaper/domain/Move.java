package at.nacs.ex8rockscissorspaper.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
public class Move {
    private String name;
    private List<String> defeats;
}
