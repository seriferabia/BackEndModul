package at.nacs.ex5thecalculator.controller;

import at.nacs.ex5thecalculator.model.Expression;
import org.springframework.stereotype.Component;

@Component
public class Expressions {

    public Expression from(String input) throws IllegalArgumentException {
        String[] split = input.split(" ");
        if (split.length != 3) {
            throw new IllegalArgumentException();
        }
        return Expression.builder().number1(Double.valueOf(split[0]))
                .symbol(split[1])
                .number2(Double.valueOf(split[2])).build();
    }
}
