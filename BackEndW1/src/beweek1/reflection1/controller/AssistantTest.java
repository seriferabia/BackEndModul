package beweek1.reflection1.controller;

import beweek1.reflection1.model.Fruit;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AssistantTest {

    @Test
    void testTranslate() {
        List<Fruit> actualFruits = Assistant.translate(getFruitNames());
        List<Fruit> expectedFruits = getExpectedList();
        assertEquals(expectedFruits,actualFruits);
    }

    @Test
    void testToFruit() {
        Map.Entry<String, Long> fruitInfo = getExpectedMap().entrySet().iterator().next();
        Fruit actual = Assistant.toFruit(fruitInfo);
        Fruit expected = Fruit.builder().name("Apple").amount(1).build();
        assertEquals(expected, actual);
    }

    @Test
    void testCountFruits() {
        Map<String, Long> actual = Assistant.countFruits(getFruitNames());
        Map<String, Long> expected = getExpectedMap();
        assertEquals(expected.entrySet(), actual.entrySet());
    }

    private Map<String, Long> getExpectedMap() {
        Map<String, Long> map = new HashMap<>();
        map.put("Orange", 4L);
        map.put("Apple", 1L);
        map.put("Banana", 1L);
        return map;
    }

    private List<Fruit> getExpectedList(){
        return Stream.of(Fruit.builder().name("Apple").amount(1).build(),
                Fruit.builder().name("Orange").amount(4).build(),
                Fruit.builder().name("Banana").amount(1).build())
                .collect(Collectors.toList());
    }

    private List<String> getFruitNames(){
        return Stream.of("Orange","Apple","Orange","Banana","Orange","Orange")
                .collect(Collectors.toList());
    }
}