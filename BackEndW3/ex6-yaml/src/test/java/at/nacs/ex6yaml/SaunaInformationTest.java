package at.nacs.ex6yaml;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SaunaInformationTest {
    @Autowired
    SaunaInformation saunaInformation;

    @Test
    void testSaunaInformation() {
        Sauna sauna = saunaInformation.getSauna();
        assertEquals(5,sauna.getAvailableSeats());
        assertEquals(36,sauna.getTemperature());
    }
}