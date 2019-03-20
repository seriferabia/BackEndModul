package at.nacs.ex6yaml;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DanceSchoolTest {
    @Autowired
    DanceSchool danceSchool;

    @ParameterizedTest
    @CsvSource({"0,dancer1,3",
                "1,dancer2,4",
                "2,dancer3,5",
    })
    void testGetBallerinas(Integer position,String name, Integer performance) {
        Ballerina ballerina = danceSchool.getBallerinas().get(position);
        assertEquals(name+" "+performance, ballerina.getName()+" "+ ballerina.getPerformanceQuality());
    }
}