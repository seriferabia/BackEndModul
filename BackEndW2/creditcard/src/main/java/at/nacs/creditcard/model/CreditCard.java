package at.nacs.creditcard.model;


import java.util.List;

public abstract class CreditCard {
    private List<Integer> lengths;
    private List<Integer> startingNumbers;

    public CreditCard(List<Integer> lengths, List<Integer> startingNumbers) {
        this.lengths = lengths;
        this.startingNumbers = startingNumbers;
    }
    public List<Integer> getLength() {
        return lengths;
    }

    public List<Integer> getStartingNumbers() {
        return startingNumbers;
    }

    public Boolean isRightCard(Integer length, Integer startingNumber){
        return getLength().contains(length) && getStartingNumbers().contains(startingNumber);
    }

    public abstract String getName();

}
