package at.nacs.rockpaper.model;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Human implements Player {
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
//    private final List<Move> moves;
//    private Scanner scanner = new Scanner(System.in);
//
//    @Override
//    public Optional<Move> chooseMove() {
//        Optional<Move> choice = Optional.empty();
//        while (!choice.isPresent()) {
//            showChoices();
//            String moveName = scanner.nextLine();
//            for (Move move : moves) {
//                if (isValid(move, moveName)) {
//                    choice = Optional.of(move);
//                    return choice;
//                }
//            }
//        }
//        return Optional.empty();
//    }
//
//    private boolean isValid(Move move, String moveName) {
//        return move.getName().equalsIgnoreCase(moveName);
//    }
//
//    public void showChoices() {
//        System.out.println("These are your options: " + getOptions());
//        System.out.println("Choose one :");
//    }
//
//    private String getOptions() {
//        return moves.stream().map(e -> e.getName()).collect(Collectors.joining(" "));
//    }
//
//    @Override
//    public Boolean playAgain() {
//        System.out.println("Do you want play again? (yes/no)");
//        String answer = scanner.nextLine();
//        return answer.equalsIgnoreCase("yes");
//
//    }
}
