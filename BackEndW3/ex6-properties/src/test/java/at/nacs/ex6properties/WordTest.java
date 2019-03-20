package at.nacs.ex6properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WordTest {

    @Autowired
    Word word;

    @Test
    void getWord() {
        Assertions.assertEquals("fantastic",word.getWord());
    }
}