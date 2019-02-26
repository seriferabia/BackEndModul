package beweek1.ex1.controller.selection;

import beweek1.ex1.model.Bean;
import beweek1.ex1.model.CoffeeCan;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SelectionMakerTest {

    @Test
    void testCompleteSelection() {
        CoffeeCan finalCan = SelectionMaker.completeSelection(getACan());
        assertEquals(1,finalCan.getBeans().size());
    }

    @Test
    void testMakeSelection() {
        CoffeeCan originalCan = getACan();
        CoffeeCan afterSelection = SelectionMaker.makeSelection(originalCan);
        Integer sizeOfOriginalCan = originalCan.getBeans().size();
        Integer sizeOfSelectedCan = afterSelection.getBeans().size();
        assertEquals(sizeOfSelectedCan+1,sizeOfOriginalCan);
    }

    @Test
    void testMakeOneSelection() {
        CoffeeCan coffeeCan = getACan();
        List<Bean> actual = SelectionMaker.makeOneSelection(coffeeCan);
        List<Bean> expected = Arrays.asList(Bean.builder().color("white").build()
                ,Bean.builder().color("black").build());
        assertEquals(expected,actual);
    }

    @Test
    void testShuffle() {
        CoffeeCan originalCan = getACan();
        CoffeeCan shuffledCan = SelectionMaker.shuffle(originalCan);
        assertNotEquals(shuffledCan,originalCan);

    }

    private CoffeeCan getACan() {
        return CoffeeCan.builder().beans(new ArrayList<>(Arrays.asList(Bean.builder().color("white").build(),
                Bean.builder().color("black").build(),
                Bean.builder().color("black").build(),
                Bean.builder().color("white").build()))).build();
    }
}