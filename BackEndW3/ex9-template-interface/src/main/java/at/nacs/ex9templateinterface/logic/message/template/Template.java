package at.nacs.ex9templateinterface.logic.message.template;

public interface Template {

    Boolean isValid(String name);

    String apply(String name);
}
