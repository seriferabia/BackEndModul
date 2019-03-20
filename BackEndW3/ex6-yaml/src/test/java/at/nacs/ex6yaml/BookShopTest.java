package at.nacs.ex6yaml;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BookShopTest {
    @Autowired
    BookShop bookShop;

    @ParameterizedTest
    @ValueSource(strings = {"HarryPotter","TheFoundation","TheLordOfTheRings"})
    void testBooksName(String bookName) {
        assertTrue(bookShop.getBookshop().containsKey(bookName));
    }

    @ParameterizedTest
    @CsvSource({
            "HarryPotter,3",
            "TheFoundation,2",
            "TheLordOfTheRings,4"
    })
    void testNumberOfBooks(String name, Integer amount){
        assertEquals(amount,bookShop.getBookshop().get(name));
    }
}