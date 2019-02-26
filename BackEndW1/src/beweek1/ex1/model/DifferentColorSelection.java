package beweek1.ex1.model;

import java.util.List;

public class DifferentColorSelection implements Selection {

    @Override
    public Boolean isThe(List<Bean> selectedBeans) {
        return selectedBeans.stream().distinct().count()>1;
    }

    @Override
    public void putBeanBack(CoffeeCan can) {
        can.addBean(Bean.builder().color("white").build());
    }
}
