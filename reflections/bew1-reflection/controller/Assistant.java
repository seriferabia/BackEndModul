package beweek1.reflection1.controller;

import beweek1.reflection1.model.Fruit;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

@UtilityClass
public class Assistant {
    public List<Fruit> translate(List<String> fruitNames) {
        return countFruits(fruitNames).entrySet().stream()
                .map(e->toFruit(e))
                .collect(Collectors.toList());
    }

    Fruit toFruit(Map.Entry<String, Long> fruitInfo) {
        return Fruit.builder().name(fruitInfo.getKey()).amount(fruitInfo.getValue()).build();
    }

    Map<String, Long> countFruits(List<String> fruitNames) {
        return fruitNames.stream()
                .collect(groupingBy(Function.identity(), counting()));
    }
}
