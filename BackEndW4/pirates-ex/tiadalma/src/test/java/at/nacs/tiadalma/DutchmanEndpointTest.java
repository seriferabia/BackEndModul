package at.nacs.tiadalma;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DutchmanEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/dutchman";

    @Test
    void dutchmansUrl() {
        String actual = testRestTemplate.getForObject(url, String.class);
        String expected = "http://localhost:9002/deadmanschest";
        Assertions.assertThat(actual).isEqualTo(expected);
    }
}