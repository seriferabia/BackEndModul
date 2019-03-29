package beweek1.reflection1;

import beweek1.reflection1.controller.Assistant;
import beweek1.reflection1.controller.DeliveryInformation;
import beweek1.reflection1.model.Fruit;
import beweek1.reflection1.view.FruitCounter;

import java.util.List;

public class FruitShopApp {
    public static void main(String[] args) {
        List<String> fruitNames = DeliveryInformation.getInformation("beweek1/reflection1/file/delivery.txt");
        List<Fruit> fruits = Assistant.translate(fruitNames);
        FruitCounter.display(fruits);
    }
}
