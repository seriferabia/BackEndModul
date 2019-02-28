package at.nacs.creditcard.controller;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class DigitListProvider {
    public List<Integer> getAllDigits(Long cardNumber) {
        return Stream.of(cardNumber.toString().split("")).map(e -> Integer.valueOf(e)).collect(Collectors.toList());
    }

    public List<Integer> getDigitsForMultiplication(Long cardNumber) {
        List<Integer> allDigits = getAllDigits(cardNumber);
        int size = allDigits.size();
        List<Integer> digits1 = new ArrayList<>();
        for (int position = size - 2; position >= 0; position -= 2) {
            digits1.add(allDigits.get(position));
        }
        return digits1;
    }

    public List<Integer> getRemainDigits(List<Integer> allDigits, List<Integer> digits1) {
        for (Integer digit : digits1) {
            allDigits.remove(digit);
        }
        return allDigits;
    }
}
