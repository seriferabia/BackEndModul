package beweek1.ex1.controller.statistics;

import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
@UtilityClass
public class OverallStatisticsCollector {
    public List<String> getOverallStatistics(){
        return IntStream.range(0,getResults().size())
                .boxed()
                .map(e->getQuestions().get(e)+" "+getResults().get(e))
                .collect(Collectors.toList());

    }
    private List<String> getResults(){
        return Stream.of(OverallStatisticsCalculator.numberOfTries
                ,OverallStatisticsCalculator.getTotalNumberOfWhiteBeans()
                ,OverallStatisticsCalculator.getTotalNumberOfBlackBeans()
                ,OverallStatisticsCalculator.getNumberOfTimesLastBeanWhite()
                ,OverallStatisticsCalculator.getNumberOfTimesLastBeanBlack()
                ,OverallStatisticsCalculator.getTotalRatioOfWhiteBeans()
                ,OverallStatisticsCalculator.getTotalRatioOfBlackBeans()
                ,OverallStatisticsCalculator.getLastBlackBeanRatio()
                ,OverallStatisticsCalculator.getLastWhiteBeanRatio())
                .map(e->String.valueOf(e))
                .collect(Collectors.toList());
    }
    private List<String> getQuestions(){
        return Stream.of("Number of tries:"
                ,"Total number of white beans:"
                ,"Total number of black beans:"
                ,"Number of times where the last bean was white:"
                ,"Number of times where the last bean was black:"
                ,"Total ratio of white beans"
                ,"Total ratio of black beans"
                ,"Ratio of last bean as black"
                ,"Ratio of last bean as white")
                .collect(Collectors.toList());
    }
}
