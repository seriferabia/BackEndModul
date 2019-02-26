package beweek1.ex1.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Statistics {
    private double whiteBeansPercentage;
    private double blackBeansPercentage;

    private int amountOfWhiteBeans;
    private int amountOfBlackBeans;

    private Bean lastBean;

}
