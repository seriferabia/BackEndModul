package at.nacs.rockpaper.controller;


import at.nacs.rockpaper.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JudgeTest {
    @Autowired
    Judge judge;
    @Autowired
    Paper paper;
    @Autowired
    Rock rock;
    @Autowired
    Scissors scissors;

//    @ParameterizedTest
//    @CsvSource({
//            "Player1 wins !, paper, rock",
//            "Player2 wins !, paper, scissors",
//            "No Winner!, paper, paper",
//    })
//    void testJudge(String expected, Move move1, Move move2) {
//        String actual = judge.decideWinner(move1,move2);
//        Assertions.assertEquals(expected, actual);
//    }

    @Test
    void testPaperRock(){
        String decision = judge.decideWinner(paper, rock);
        String expected = "Player1 wins !";
        Assertions.assertEquals(expected,decision);
    }
    @Test
    void testPaperScissors(){
        String decision = judge.decideWinner(paper, scissors);
        String expected = "Player2 wins !";
        Assertions.assertEquals(expected,decision);
    }
    @Test
    void testPaperPaper(){
        String decision = judge.decideWinner(paper, paper);
        String expected = "No Winner!";
        Assertions.assertEquals(expected,decision);
    }
}