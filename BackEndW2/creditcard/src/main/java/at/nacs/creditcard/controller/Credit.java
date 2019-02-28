package at.nacs.creditcard.controller;

import at.nacs.creditcard.model.*;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
@Component
@RequiredArgsConstructor
public class Credit {
    private final List<CreditCard> cards;
    private final LunhsAlg lunhsAlg;
    private final Length length;
    private final Starting starting;


    public String checkCard(Long cardNumber) {
        if (!lunhsAlg.isValid(cardNumber)) {
            return "INVALIDDD";
        }
        Optional<String> cardName = getName(cardNumber);
        if(cardName.isPresent()) {
            return  getName(cardNumber).get();
        }
        System.out.println("Sorry! This card is valid but not available.");
        return "INVALID";
    }

    private Optional<String> getName(Long cardNumber) {
        int lengthOfNumber = length.getLengthOfNumber(cardNumber);
        int startingWith = starting.getStartingNumbers(cardNumber);
        for (CreditCard card : cards) {
            if (card.isRightCard(lengthOfNumber, startingWith)) {
                return Optional.of(card.getName());
            }
        }
        return Optional.empty();
    }
}
