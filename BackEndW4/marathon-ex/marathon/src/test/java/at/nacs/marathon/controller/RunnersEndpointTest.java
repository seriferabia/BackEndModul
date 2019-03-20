package at.nacs.marathon.controller;

import at.nacs.marathon.domain.Runner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class RunnersEndpointTest {
    @Autowired
    TestRestTemplate restTemplate;

    String url = "/runners";

    @Test
    void get() {
        List<Runner> runners = new ArrayList<>();
        Runner[] actualArray = restTemplate.getForObject(url, Runner[].class);
        List<Runner> actual = new ArrayList<>(Arrays.asList(actualArray));
        assertThat(actual).isEqualTo(new ArrayList<>());
    }

    @ParameterizedTest
    @CsvSource({
            "runner1, PT10S",
            "runner2, PT11S"
    })
    void add(String name, CharSequence time) {
        Duration duration = Duration.parse(time);
        Runner runner = new Runner(name, duration);

        Runner[] response = restTemplate.getForObject(url, Runner[].class);
        assertThat(response).doesNotContain(runner);

        Runner returnedAfterPost = restTemplate.postForObject(url, runner, Runner.class);
        assertThat(returnedAfterPost).isEqualTo(runner);

    }
}