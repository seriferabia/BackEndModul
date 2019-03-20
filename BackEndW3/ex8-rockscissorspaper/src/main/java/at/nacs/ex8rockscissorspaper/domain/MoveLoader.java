package at.nacs.ex8rockscissorspaper.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("game")
@Getter
@Setter
public class MoveLoader {
    private List<Move> moves;
}
