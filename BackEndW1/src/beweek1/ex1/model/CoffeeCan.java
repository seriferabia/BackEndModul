package beweek1.ex1.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CoffeeCan {
    private final Double ratioOfWhiteBeans;
    private final Double ratioOfBlackBeans;
    private List<Bean> beans;

    void addBean(Bean bean) {
        beans.add(bean);
    }
}
