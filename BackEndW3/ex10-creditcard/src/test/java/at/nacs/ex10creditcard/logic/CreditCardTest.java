package at.nacs.ex10creditcard.logic;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreditCardTest {

    @Autowired
    CreditCard creditCard;


    @ParameterizedTest
    @CsvSource({
            "378282246310005, American Express",
            "5555555555554444, MasterCard",
            "4222222222222, Visa",
            "6011583102250437, Discover",
            "6759671871310254, Maestro",
            "4913589005620679, Visa Electron",
            "6388223819764850, InstaPayment",
            "2223016768739314, INVALID",
            "3530111333300000, UNKNOWN",
    })
    void checkCreditCard(String cardNumber, String expected) {
        assertEquals(expected, creditCard.check(cardNumber));
    }
}