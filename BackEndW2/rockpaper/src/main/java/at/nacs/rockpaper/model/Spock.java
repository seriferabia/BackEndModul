package at.nacs.rockpaper.model;

import org.springframework.stereotype.Component;

@Component
public class Spock implements Move {
    @Override
    public String getName() {
        return "spock";
    }

    @Override
    public Boolean defeats(Move move) {
        boolean move1 = "scissors".equalsIgnoreCase(move.getName());
        boolean move2 = "rock".equalsIgnoreCase(move.getName());
        return move1 || move2;
    }
}
