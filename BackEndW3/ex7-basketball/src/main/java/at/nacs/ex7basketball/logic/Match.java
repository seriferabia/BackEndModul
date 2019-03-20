package at.nacs.ex7basketball.logic;

import at.nacs.ex7basketball.domain.BasketballTeam;
import at.nacs.ex7basketball.domain.TeamLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
public class Match {

    private final TeamLoader teamLoader;

    public BasketballTeam getChampion() {
        Queue<BasketballTeam> teams = new LinkedList<>();
        teamLoader.getTeams().stream()
                .forEach(team->((LinkedList<BasketballTeam>) teams).add(team));
        while (teams.size() > 1) {
            List<BasketballTeam> competitors = takeCompetitors(teams);
            System.out.println(competitors.get(0).getName() + " plays vs " + competitors.get(1).getName());
            BasketballTeam winner = getWinner(competitors);
            System.out.println(winner.getName() + " wins the match!");
            teams.add(winner);
        }
        return teams.poll();
    }

    private BasketballTeam getWinner(List<BasketballTeam> competitors) {
        int winnerIndex = new Random().nextInt(2);
        return competitors.get(winnerIndex);
    }

    private List<BasketballTeam> takeCompetitors(Queue<BasketballTeam> teams) {
        return Stream.of(teams.poll(), teams.poll())
                .collect(Collectors.toList());
    }
}