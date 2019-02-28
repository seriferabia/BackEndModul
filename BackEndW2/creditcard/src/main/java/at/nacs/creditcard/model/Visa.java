package at.nacs.creditcard.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class Visa extends CreditCard {


    public Visa() {
        super(Arrays.asList(13,16), Arrays.asList(4));
    }

    @Override
    public String getName() {
        return "Visa";
    }


}
