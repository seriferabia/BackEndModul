package beweek1.ex1.view;

import beweek1.ex1.model.Statistics;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class StatisticsDemonstration {

    public void display(List<Statistics> statistics) {
        statistics.stream()
                .forEach(e -> display(e));
    }

    void display(Statistics statistics) {
        System.out.println(statistics);
    }
}
