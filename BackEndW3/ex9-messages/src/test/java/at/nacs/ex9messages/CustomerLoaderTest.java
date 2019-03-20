package at.nacs.ex9messages;

import at.nacs.ex9messages.logic.CustomerLoader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CustomerLoaderTest {
    @Autowired
    CustomerLoader customerLoader;

    @Test
    void testGetNames() {
        assertEquals(22,customerLoader.getNames().size());
    }
}