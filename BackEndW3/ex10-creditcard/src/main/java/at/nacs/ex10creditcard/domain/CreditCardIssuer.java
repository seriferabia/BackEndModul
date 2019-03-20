package at.nacs.ex10creditcard.domain;

import lombok.Data;

import java.util.List;

@Data
public class CreditCardIssuer {
    private String name;
    private List<String> startWith;
    private List<String> notStartWith;
    private List<Integer> lengths;
}
