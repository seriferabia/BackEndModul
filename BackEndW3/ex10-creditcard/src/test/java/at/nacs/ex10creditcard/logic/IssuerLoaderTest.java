package at.nacs.ex10creditcard.logic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class IssuerLoaderTest {
    @Autowired
    IssuerLoader loader;

    @ParameterizedTest
    @CsvSource({
            "0,MasterCard",
            "1,Visa",
            "2,Visa Electron"
    })
    void testIssuersNames(Integer index, String name) {
        assertEquals(name, loader.getIssuers().get(index).getName());
    }

    @ParameterizedTest
    @CsvSource({
            "0,1",
            "1,3",
            "2,1"
    })
    void testIssuersLengths(Integer index, int expected) {
        assertEquals(expected, loader.getIssuers().get(index).getLengths().size());
    }

    @ParameterizedTest
    @CsvSource({
            "0,0",
            "1,6",
            "2,0"
    })
    void testIssuersNotStartWith(Integer index, int expectedSize) {
        assertEquals(expectedSize, loader.getIssuers().get(index).getNotStartWith().size());
    }


}