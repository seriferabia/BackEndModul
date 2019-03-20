package at.nacs.ex8rockscissorspaper.logic.player;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.domain.MoveLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class ComputerPlayer implements Player {
    private final MoveLoader moveLoader;
    private Random random = new Random();

    @Override
    public Move choose() {
        int numberOfMoves = moveLoader.getMoves().size();
        int position = random.nextInt(numberOfMoves);
        return moveLoader.getMoves().get(position);
    }

    @Override
    public boolean wantsToPlayAgain() {
        return true;
    }
}
