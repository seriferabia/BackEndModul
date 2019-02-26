package beweek1.ex1.controller.statistics;

import beweek1.ex1.model.Statistics;
import lombok.experimental.UtilityClass;

import java.util.List;
@UtilityClass
public class OverallStatisticsCalculator {
    int numberOfTries = 10;
    private List<Statistics> statistics = StatisticsCollector.collectStatistics(numberOfTries);

    public int getTotalNumberOfWhiteBeans(){
        return statistics.stream()
                .map(e->e.getAmountOfWhiteBeans())
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int getTotalNumberOfBlackBeans(){
        return statistics.stream()
                .map(e->e.getAmountOfBlackBeans())
                .mapToInt(Integer::intValue)
                .sum();
    }
    public long getNumberOfTimesLastBeanWhite(){
        return statistics.stream()
                .filter(e->e.getLastBean().getColor().equals("white"))
                .count();
    }

    public long getNumberOfTimesLastBeanBlack(){
        return statistics.stream()
                .filter(e->e.getLastBean().getColor().equals("black"))
                .count();
    }

    public double getTotalRatioOfWhiteBeans(){
        int totalAmount = getTotalNumberOfBlackBeans()+getTotalNumberOfWhiteBeans();
        return getTotalNumberOfWhiteBeans()*100/totalAmount;
    }

    public double getTotalRatioOfBlackBeans(){
        int totalAmount = getTotalNumberOfBlackBeans()+getTotalNumberOfWhiteBeans();
        return getTotalNumberOfBlackBeans()*100/totalAmount;
    }

    public double getLastWhiteBeanRatio(){
        return getNumberOfTimesLastBeanWhite()*100/numberOfTries;
    }

    public double getLastBlackBeanRatio(){
        return getNumberOfTimesLastBeanBlack()*100/numberOfTries;
    }
}
