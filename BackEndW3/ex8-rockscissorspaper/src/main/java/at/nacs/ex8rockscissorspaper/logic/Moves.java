package at.nacs.ex8rockscissorspaper.logic;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.domain.MoveLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Moves {
    private final MoveLoader moveLoader;

    public String getMoveNames() {
        return moveLoader.getMoves().stream()
                .map(move -> move.getName())
                .collect(Collectors.joining(", "));
    }

    public Optional<Move> from(String name) {
        return moveLoader.getMoves().stream()
                .filter(move -> Objects.equals(name, move.getName()))
                .findFirst();
    }
}
