package at.nacs.rockpaper.model;

import java.util.Optional;

public interface Player {
    Optional<Move> chooseMove();
    Boolean playAgain();
}
