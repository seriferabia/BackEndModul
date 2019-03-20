package at.nacs.ex9messages;

import at.nacs.ex9messages.logic.TemplateEngine;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TemplateEngineTest {
    @Autowired
    TemplateEngine templateEngine;

    @Test
    void testPrivilegedTemplate() {
        String message = templateEngine.returnMessage("Daniela Threepwood");
        String expected = "My dearest Daniela Threepwood, your lovely family gives you a 20% discount on tickets this Friday!";
        assertEquals(expected,message);
    }

    @Test
    void testManTemplate() {
        String message = templateEngine.returnMessage("Mr. Erguner");
        String expected = "Good day Mr. Erguner, do not forget our 20% discount on tickets this Friday!";
        assertEquals(expected,message);
    }

    @Test
    void testWomanTemplate() {
        String message = templateEngine.returnMessage("Mrs. Erguner");
        String expected = "Dear Mrs. Erguner, you and your friends will have so much fun at the cinema this Friday with a 20% discount!";
        assertEquals(expected,message);
    }

    @Test
    void testDefaultTemplate() {
        String message = templateEngine.returnMessage("Serife");
        String expected = "Hello Serife! How about a Friday night movie? This week with a 20% discount!";
        assertEquals(expected,message);
    }
}