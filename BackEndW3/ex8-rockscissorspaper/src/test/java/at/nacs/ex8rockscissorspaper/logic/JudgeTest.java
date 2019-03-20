package at.nacs.ex8rockscissorspaper.logic;

import at.nacs.ex8rockscissorspaper.domain.Move;
import at.nacs.ex8rockscissorspaper.domain.MoveLoader;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class JudgeTest {
    @Autowired
    Judge judge;
    @Autowired
    MoveLoader moveLoader;

    @ParameterizedTest
    @CsvSource({
            "Player 1 wins, rock, scissors",
            "Player 2 wins, rock, paper",
            "Nobody wins, rock, rock",
    })
    void judge(String expected, String name1, String name2) {
        Move move1 = getMove(name1);
        Move move2 = getMove(name2);
        String result = judge.judge(move1, move2);
        assertEquals(expected, result);
    }

    private Move getMove(String name) {
        return moveLoader.getMoves().stream()
                .filter(move -> move.getName().equals(name))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }

}