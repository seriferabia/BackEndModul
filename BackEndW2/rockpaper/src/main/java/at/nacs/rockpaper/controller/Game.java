package at.nacs.rockpaper.controller;

import at.nacs.rockpaper.model.Computer;
import at.nacs.rockpaper.model.Human;
import at.nacs.rockpaper.model.Move;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Game {

    private final Human player1;
    private final Computer player2;
    private final Judge judge ;

    public void play() {
        Boolean playAgain = true;
        while (playAgain) {
            playOneRound();
            playAgain = getPlayAgain();
        }
        System.out.println("See you next time!");
    }

    private void playOneRound() {
        displayMenu();
        Move move1 = player1.chooseMove().get();
        Move move2 = player2.chooseMove().get();
        displayAllAnswers(move1, move2);
        System.out.println(judge.decideWinner(move1, move2));
    }

    private Boolean getPlayAgain() {
        return player1.playAgain() && player2.playAgain();
    }

    public void displayMenu() {
        System.out.println("Let’s play rock, paper, scissors!");
    }

    private void displayAllAnswers(Move move1, Move move2) {
        System.out.println("Player1 choose : " + move1.getName());
        System.out.println("Player2 choose : " + move2.getName());
    }
}
