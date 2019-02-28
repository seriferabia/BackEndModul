package at.nacs.creditcard.controller;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class Starting {
    public Integer getStartingNumbers(Long cardNumber){
        List<String> digits = Stream.of(cardNumber.toString().split("")).collect(Collectors.toList());
        if (digits.get(0).equals("4")){
            return Integer.valueOf(digits.get(0));
        }
        List<String> startingDigits = Arrays.asList(digits.get(0),digits.get(1));
        return Integer.valueOf(String.join("",startingDigits));

    }
}
