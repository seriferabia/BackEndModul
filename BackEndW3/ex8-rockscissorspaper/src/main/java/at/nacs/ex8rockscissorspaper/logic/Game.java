package at.nacs.ex8rockscissorspaper.logic;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.logic.player.ComputerPlayer;
import at.nacs.ex8rockscissorspaper.logic.player.HumanPlayer;
import at.nacs.ex8rockscissorspaper.logic.player.Player;
import at.nacs.ex8rockscissorspaper.ui.Host;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Game {
    private final Player humanPlayer;
    private final Player computerPlayer;
    private final Host host;
    private final Judge judge;

    public void play() {
        host.displayMenu();
        Boolean playAgain = true;
        while (playAgain) {
            playOneRound();
            playAgain = getPlayAgain();
        }
        System.out.println("See you next time!");
    }

    private void playOneRound() {
        Move move1 = humanPlayer.choose();
        Move move2 = computerPlayer.choose();
        host.displaySelectedAnswers(move1, move2);
        System.out.println(judge.judge(move1, move2));
    }

    private Boolean getPlayAgain() {
        return humanPlayer.wantsToPlayAgain() && computerPlayer.wantsToPlayAgain();
    }

}
