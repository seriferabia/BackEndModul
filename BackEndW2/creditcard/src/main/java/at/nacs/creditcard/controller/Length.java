package at.nacs.creditcard.controller;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;
import java.util.stream.Stream;
@Component
public class Length {
    public Integer getLengthOfNumber(Long cardNumber) {
        return cardNumber.toString().length();
    }
}
