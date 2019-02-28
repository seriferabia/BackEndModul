package at.nacs.creditcard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LunhsAlg {
    private final Validator validator;

    public Boolean isValid(Long cardNumber) {
        Integer total = validator.getFinalSumOfDigits(cardNumber);
        return total % 10 == 0;
    }
}
