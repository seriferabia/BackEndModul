package at.nacs.ex8rockscissorspaper.domain;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class MoveLoaderTest {
    @Autowired
    MoveLoader moveLoader;

    @ParameterizedTest
    @CsvSource({
            "0,rock, scissors",
            "1,paper, rock",
            "2,scissors, paper"

    })
    void testGetMoves(Integer index, String name,String defeat) {
        assertEquals(name,moveLoader.getMoves().get(index).getName());
        assertEquals(defeat,moveLoader.getMoves().get(index).getDefeats().get(0));
    }
}