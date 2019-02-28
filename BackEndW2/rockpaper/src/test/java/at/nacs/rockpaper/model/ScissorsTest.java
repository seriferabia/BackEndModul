package at.nacs.rockpaper.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ScissorsTest {
    @Autowired
    Scissors scissors;
    @Autowired
    Paper paper;
    @Autowired
    Rock rock;

    @Test
    void defeats() {
        assertTrue(scissors.defeats(paper));
        assertFalse( scissors.defeats(rock));
    }
}