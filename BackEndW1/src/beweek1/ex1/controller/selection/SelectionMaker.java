package beweek1.ex1.controller.selection;

import beweek1.ex1.model.*;
import lombok.experimental.UtilityClass;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class SelectionMaker {
    private List<Selection> selections = Arrays.asList(new SameColorSelection(), new DifferentColorSelection());

    public CoffeeCan completeSelection(CoffeeCan can) {
        while (can.getBeans().size() > 1) {
            can = makeSelection(can);
        }
        return can;
    }

    CoffeeCan makeSelection(CoffeeCan can) {
        can = shuffle(can);
        List<Bean> oneSelection = makeOneSelection(can);
        for (Selection selection : selections) {
            if (selection.isThe(oneSelection)) {
                selection.putBeanBack(can);
            }
        }
        return can;
    }

    List<Bean> makeOneSelection(CoffeeCan shuffledCan) {
        List<Bean> beans = shuffledCan.getBeans();
        return Stream.of(beans.remove(0), beans.remove(0))
                .collect(Collectors.toList());
    }

    CoffeeCan shuffle(CoffeeCan can) {
        List<Bean> shuffled = new LinkedList<>(can.getBeans());
        Collections.shuffle(shuffled);
        return CoffeeCan.builder().beans(shuffled)
                .ratioOfBlackBeans(can.getRatioOfBlackBeans())
                .ratioOfWhiteBeans(can.getRatioOfWhiteBeans())
                .build();
    }
}
