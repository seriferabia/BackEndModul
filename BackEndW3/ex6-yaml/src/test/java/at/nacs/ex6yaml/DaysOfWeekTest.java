package at.nacs.ex6yaml;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DaysOfWeekTest {
    @Autowired
    DaysOfWeek daysOfWeek;

    @ParameterizedTest
    @CsvSource({"monday,0",
                "tuesday,1 ",
                "wednesday,2",
                "thursday,3 ",
                "friday,4",
                "saturday,5",
                "sunday,6"})
    void testDays(String expected, Integer order) {
        List<String> days = daysOfWeek.getDays();
        assertEquals(expected,days.get(order));
    }
}