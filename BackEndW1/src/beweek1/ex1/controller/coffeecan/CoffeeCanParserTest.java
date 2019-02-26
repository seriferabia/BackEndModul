package beweek1.ex1.controller.coffeecan;

import beweek1.ex1.model.Bean;
import beweek1.ex1.model.CoffeeCan;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeCanParserTest {
    private final int AMOUNT_OF_BEANS = 11;

    @Test
    void testGetCoffeeCan() {
        //test if method gives us different cans
        CoffeeCan can1 = CoffeeCanParser.getCoffeeCan(11);
        CoffeeCan can2 = CoffeeCanParser.getCoffeeCan(11);
        assertNotEquals(can1,can2);
    }

    @Test
    void testAddBean() {
        List<Bean> beans = new ArrayList<>();
        double ratio = 20.00;
        String color = "white";
        CoffeeCanParser.addBean(beans,ratio,AMOUNT_OF_BEANS,color);
        int sizeOfExpectedList = (int) (AMOUNT_OF_BEANS*ratio/100);
        List<Bean> expected = IntStream.range(0,sizeOfExpectedList)
                .mapToObj(e->Bean.builder().color(color).build())
                .collect(Collectors.toList());
        assertEquals(expected,beans);
    }
}