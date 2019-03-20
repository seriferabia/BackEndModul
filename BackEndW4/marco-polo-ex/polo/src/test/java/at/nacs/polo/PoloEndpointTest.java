package at.nacs.polo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class PoloEndpointTest {

    @Autowired
    TestRestTemplate restTemplate;

    String url = "/polo";

    @Test
    void message() {

        String actual = restTemplate.postForObject(url, "Marco", String.class);
        assertThat(actual).isEqualTo("Polo");

        actual = restTemplate.postForObject(url,"Serife",String.class);
        assertThat(actual).isEqualTo("What?");

    }
}