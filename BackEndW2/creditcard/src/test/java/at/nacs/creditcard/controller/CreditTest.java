package at.nacs.creditcard.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CreditTest {
    @Autowired
    Credit credit;
    @ParameterizedTest
    @CsvSource({
            "INVALIDDD, 5105105105105 ",
            "American Express, 371449635398431",
            "Master Card, 5555555555554444",
            "Visa, 4012888888881881",
            "INVALID, 6011000990139424"
    })
    void testCheckCard(String expected, Long cardNumber ) {
        String result = credit.checkCard(cardNumber);
        Assertions.assertEquals(expected, result);
    }
}