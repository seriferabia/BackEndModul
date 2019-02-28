package at.nacs.creditcard.controller;

import at.nacs.creditcard.controller.AlgorithmCalculator;
import at.nacs.creditcard.controller.DigitListProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@RequiredArgsConstructor
public class Validator {
    private final DigitListProvider listProvider;
    private final AlgorithmCalculator calculator;

    public Integer getFinalSumOfDigits(Long cardNumber) {
        List<Integer> allDigits = listProvider.getAllDigits(cardNumber);
        List<Integer> secondToLastDigits = listProvider.getDigitsForMultiplication(cardNumber);
        Integer sumOfSecondToLastDigit = calculator.sumOfMultipliedDigits(secondToLastDigits);
        List<Integer> remainDigits = listProvider.getRemainDigits(allDigits, secondToLastDigits);
        Integer sumOfRemainDigits = calculator.sumDigitsOfList(remainDigits);
        Integer total = sumOfSecondToLastDigit + sumOfRemainDigits;
        return total;
    }
}
