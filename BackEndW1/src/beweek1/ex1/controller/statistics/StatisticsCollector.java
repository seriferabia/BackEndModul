package beweek1.ex1.controller.statistics;

import beweek1.ex1.controller.selection.SelectionMaker;
import beweek1.ex1.controller.coffeecan.CoffeeCanParser;
import beweek1.ex1.model.CoffeeCan;
import beweek1.ex1.model.Statistics;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@UtilityClass
public class StatisticsCollector {
    private final int TOTAL_AMOUNT = 1001;

    public List<Statistics> collectStatistics(Integer numberOfTries) {
        return IntStream.generate(() -> 0)
                .limit(numberOfTries)
                .mapToObj(n -> CoffeeCanParser.getCoffeeCan(TOTAL_AMOUNT))
                .map(can -> SelectionMaker.completeSelection(can))
                .map(e -> toStatistics(e))
                .collect(Collectors.toList());
    }

    private Statistics toStatistics(CoffeeCan can) {
        int amountOfWhite = (int) (TOTAL_AMOUNT * can.getRatioOfWhiteBeans() / 100);
        int amountOfBlack = (int) (TOTAL_AMOUNT * can.getRatioOfBlackBeans() / 100);
        return Statistics.builder().blackBeansPercentage(can.getRatioOfBlackBeans())
                .whiteBeansPercentage(can.getRatioOfWhiteBeans())
                .amountOfWhiteBeans(amountOfWhite)
                .amountOfBlackBeans(amountOfBlack)
                .lastBean(can.getBeans().get(0)).build();
    }
}
