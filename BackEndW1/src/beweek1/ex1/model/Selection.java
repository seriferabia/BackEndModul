package beweek1.ex1.model;

import java.util.List;

public interface Selection {
    Boolean isThe(List<Bean> selectedBeans);
    void putBeanBack(CoffeeCan can);
}
