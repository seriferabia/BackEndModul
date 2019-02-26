package beweek1.reflection1.view;

import beweek1.reflection1.model.Fruit;
import lombok.experimental.UtilityClass;
import java.util.List;

@UtilityClass
public class FruitCounter {
    public void display(List<Fruit> fruits) {
        System.out.println("These are all our tasteful fruits:");
        fruits.stream()
                .forEach(e -> display(e));
    }

    private void display(Fruit fruit) {
        System.out.println(fruit.getAmount() + " " + fruit.getName());
    }
}
