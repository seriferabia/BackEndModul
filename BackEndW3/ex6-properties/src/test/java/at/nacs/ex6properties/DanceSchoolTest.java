package at.nacs.ex6properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
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