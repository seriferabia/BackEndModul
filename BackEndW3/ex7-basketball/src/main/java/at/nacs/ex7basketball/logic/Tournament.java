package at.nacs.ex7basketball.logic;

import at.nacs.ex7basketball.domain.BasketballTeam;
import at.nacs.ex7basketball.domain.TeamLoader;
import at.nacs.ex7basketball.logic.Match;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Tournament {
    private final TeamLoader teamLoader;
    private final Match match;

    public void introduceTeams(){
        System.out.println("---------------------------------------------");
        System.out.println("Welcome to the street basketball tournament!");
        teamLoader.getTeams().stream()
                .forEach(System.out::println);
        System.out.println("---------------------------------------------");
    }

    public void displayMatchResults(){
        BasketballTeam champion = match.getChampion();
        System.out.println("---------------------------------------------");
        System.out.println("Champion is "+ champion.getName());
    }
}
