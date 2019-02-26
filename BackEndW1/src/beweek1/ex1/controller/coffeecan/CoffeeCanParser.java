package beweek1.ex1.controller.coffeecan;

import beweek1.ex1.model.Bean;
import beweek1.ex1.model.CoffeeCan;
import lombok.experimental.UtilityClass;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@UtilityClass
public class CoffeeCanParser {
    private DecimalFormat formatter = new DecimalFormat("#.00");

    public CoffeeCan getCoffeeCan(Integer totalAmountOfBeans) {
        List<Bean> beans = new ArrayList<>();
        double ratioOfWhiteBeans = getARandomRatio();
        double ratioOfBlackBeans = Double.valueOf(formatter.format(100 - ratioOfWhiteBeans));
        addBean(beans, ratioOfWhiteBeans, totalAmountOfBeans, "white");
        addBean(beans, ratioOfBlackBeans, totalAmountOfBeans, "black");
        Collections.shuffle(beans);
        return CoffeeCan.builder().beans(beans)
                .ratioOfBlackBeans(ratioOfBlackBeans).ratioOfWhiteBeans(ratioOfWhiteBeans).build();
    }

    void addBean(List<Bean> beans, double ratio, int totalAmount, String color) {
        int amount = (int) (totalAmount * ratio / 100);
        IntStream.iterate(0, n -> n + 1)
                .limit(amount)
                .mapToObj(e -> Bean.builder().color(color).build())
                .forEach(e -> beans.add(e));
    }

    private double getARandomRatio() {
        String ratio = formatter.format(Math.random() * 100);
        return Double.valueOf(ratio);
    }
}