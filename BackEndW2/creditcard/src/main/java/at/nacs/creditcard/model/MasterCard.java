package at.nacs.creditcard.model;

import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
public class MasterCard extends CreditCard {


    public MasterCard() {
        super(Arrays.asList(16), Arrays.asList(51,52,53,54,55));
    }

    @Override
    public String getName() {
        return "Master Card";
    }


}
