package at.nacs.ex10creditcard.logic;

import at.nacs.ex10creditcard.validator.LuhnAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreditCard {
    private final LuhnAlgorithm algorithm;
    private final IssuerChecker issuerChecker;

    public String check(String cardNumber) {
        if (!algorithm.isValid(cardNumber)) {
            return "INVALID";
        }
        return issuerChecker.getIssuerNameFor(cardNumber);
    }
}
