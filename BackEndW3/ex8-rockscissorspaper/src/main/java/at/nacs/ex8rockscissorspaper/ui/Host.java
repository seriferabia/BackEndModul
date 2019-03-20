package at.nacs.ex8rockscissorspaper.ui;

import at.nacs.ex8rockscissorspaper.domain.Move;
import org.springframework.stereotype.Component;

@Component
public class Host {

    public void displayMenu() {
        System.out.println("Let’s play rock, paper, scissors!");
    }

    public void displaySelectedAnswers(Move move1, Move move2) {
        System.out.println("Player1 chose : " + move1.getName());
        System.out.println("Player2 chose : " + move2.getName());
    }
}
