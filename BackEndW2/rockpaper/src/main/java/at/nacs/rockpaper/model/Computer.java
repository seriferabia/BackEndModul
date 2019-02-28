package at.nacs.rockpaper.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;
@Component
@RequiredArgsConstructor
public class Computer implements Player {
    private final List<Move> moves;


    @Override
    public Optional<Move> chooseMove() {
        Random random = new Random();
        int position = random.nextInt(moves.size());
        return Optional.of(moves.get(position));
    }

    @Override
    public Boolean playAgain() {
        return true;
    }
}