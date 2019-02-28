package at.nacs.rockpaper.controller;

import at.nacs.rockpaper.model.Move;
import org.springframework.stereotype.Component;

@Component
public class Judge {

    public String decideWinner(Move move1, Move move2) {
        if (move1.defeats(move2)) {
            return "Player1 wins !";
        }
        if (move2.defeats(move1)) {
            return "Player2 wins !";

        }
        return "No Winner!";
    }

}
