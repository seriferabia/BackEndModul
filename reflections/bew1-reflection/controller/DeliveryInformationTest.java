package beweek1.reflection1.controller;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class DeliveryInformationTest {

    @Test
    void testGetDeliveryInformation() {
        List<String> expected = getFruitNames();
        List<String> actual = DeliveryInformation.getInformation("beweek1/reflection1/file/test.txt");
        assertEquals(expected,actual);
    }

    private List<String> getFruitNames(){
        return Stream.of("Orange","Apple","Orange","Banana","Orange","Orange")
                .collect(Collectors.toList());
    }
}