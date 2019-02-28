package at.nacs.rockpaper.model;

import org.springframework.stereotype.Component;

@Component
public class Lizard implements Move {
    @Override
    public String getName() {
        return "lizard";
    }

    @Override
    public Boolean defeats(Move move) {
        boolean move1 = "spock".equalsIgnoreCase(move.getName());
        boolean move2 = "paper".equalsIgnoreCase(move.getName());
        return move1 || move2;
    }
}
