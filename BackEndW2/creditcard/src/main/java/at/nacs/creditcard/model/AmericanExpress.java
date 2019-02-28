package at.nacs.creditcard.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class AmericanExpress extends CreditCard {


    public AmericanExpress() {
        super(Arrays.asList(15), Arrays.asList(34,37));
    }

    @Override
    public String getName() {
        return "American Express";
    }


}
