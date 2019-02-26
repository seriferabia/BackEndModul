package beweek1.ex1.view;

import beweek1.ex1.controller.statistics.OverallStatisticsCollector;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReportWriter {
    public static void main(String[] args) {
        List<String> overallStatistics = OverallStatisticsCollector.getOverallStatistics();
        write(overallStatistics,"Statistics.txt");
    }
    public static void write(List<String> lines, String filePath) {
        try {
            Path path = Paths.get(filePath);
            Files.write(path, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
