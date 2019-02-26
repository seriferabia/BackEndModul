package at.nacs.ex5thecalculator.model;

import org.springframework.stereotype.Component;

@Component
public class Summation implements Operation {
    @Override
    public Boolean matches(Expression expression) {
        return expression.getSymbol().equals("+");
    }

    @Override
    public double apply(Expression expression) {
        return expression.getNumber1() + expression.getNumber2();
    }
}
