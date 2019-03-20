package at.nacs.ex10creditcard.logic;

import at.nacs.ex10creditcard.domain.CreditCardIssuer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IssuerChecker {
    private final IssuerLoader issuerLoader;

    public String getIssuerNameFor(String cardNumber) {
        return issuerLoader.getIssuers().stream()
                .filter(e -> isTheRightOneFor(e, cardNumber))
                .map(issuer -> issuer.getName())
                .findFirst().orElse("UNKNOWN");
    }

    private Boolean isTheRightOneFor(CreditCardIssuer issuer, String cardNumber) {
        Boolean lengthValidation = checkLength(issuer, cardNumber);
        Boolean startWithValidation = checkStartWith(issuer, cardNumber);
        Boolean notStartWithValidation = checkNotStartWith(issuer, cardNumber);
        return lengthValidation && startWithValidation && notStartWithValidation;
    }

    private Boolean checkNotStartWith(CreditCardIssuer issuer, String cardNumber) {
        if (issuer.getNotStartWith().size() == 0) {
            return true;
        }
        return issuer.getNotStartWith().stream()
                .noneMatch(e -> cardNumber.startsWith(e));
    }

    private Boolean checkStartWith(CreditCardIssuer issuer, String cardNumber) {
        return issuer.getStartWith().stream()
                .anyMatch(e -> cardNumber.startsWith(e));
    }

    private Boolean checkLength(CreditCardIssuer issuer, String cardNumber) {
        return issuer.getLengths().contains(cardNumber.length());
    }
}
