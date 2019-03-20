package at.nacs.ex10creditcard.validator;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class LuhnAlgorithm {
    public Boolean isValid(String cardNumber) {
        return calculate(cardNumber) % 10 == 0;
    }

    private Integer calculate(String cardNumber) {
        List<Integer> digits = getDigits(cardNumber);
        Collections.reverse(digits);
        return IntStream.iterate(0, n -> n + 1)
                .limit(digits.size())
                .boxed()
                .map(e -> operate(e, digits))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Integer operate(Integer position, List<Integer> digits) {
        if (position % 2 == 0) {
            return digits.get(position);
        }
        int multipliedDigit = digits.get(position) * 2;
        if (multipliedDigit < 10) {
            return multipliedDigit;
        }
        return multipliedDigit - 9;
    }

    private List<Integer> getDigits(String cardNumber) {
        return new ArrayList<>(Arrays.asList(cardNumber.split("")))
                .stream().map(letter -> Integer.valueOf(letter))
                .collect(Collectors.toList());
    }
}
