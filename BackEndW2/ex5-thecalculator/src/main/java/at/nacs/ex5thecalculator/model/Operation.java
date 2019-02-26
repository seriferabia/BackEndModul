package at.nacs.ex5thecalculator.model;

public interface Operation {
    Boolean matches(Expression expression);

    double apply(Expression expression);
}
