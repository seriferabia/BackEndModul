package at.nacs.ex8rockscissorspaper.logic.player;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.logic.Moves;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class HumanPlayer implements Player {
    private final Moves moves;
    private Scanner scanner = new Scanner(System.in);


    @Override
    public Move choose() {
        Optional<Move> move = Optional.empty();
        while (move.isEmpty()) {
            move = getMove();
        }
        return move.get();
    }

    private Optional<Move> getMove() {
        System.out.println("Choose your move (" + moves.getMoveNames() + "): ");
        String name = scanner.next();
        return moves.from(name);
    }

    @Override
    public boolean wantsToPlayAgain() {
        System.out.println("Do you want to play again? (yes/no): ");
        String choice = scanner.next();
        return Objects.equals(choice, "yes");
    }
}
