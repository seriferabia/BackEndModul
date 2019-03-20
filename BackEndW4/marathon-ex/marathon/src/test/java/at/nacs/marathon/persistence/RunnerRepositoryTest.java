package at.nacs.marathon.persistence;

import at.nacs.marathon.domain.Runner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class RunnerRepositoryTest {

    @Autowired
    RunnerRepository runnerRepository;

    @Test
    void add() {
        Runner runner = new Runner("runner1", Duration.parse("PT11S"));
        runnerRepository.add(runner);
        int actualSize = runnerRepository.findAll().size();
        assertThat(actualSize).isEqualTo(1);
    }

    @Test
    void findAll() {
        List<Runner> actual = runnerRepository.findAll();
        assertThat(actual).isEmpty();
    }

    @ParameterizedTest
    @CsvSource({
            "runner1, PT10S",
            "runner2, PT11S"
    })
    void add(String name, CharSequence time) {
        Duration duration = Duration.parse(time);
        Runner runner = new Runner(name, duration);
        runnerRepository.add(runner);

        Optional<Runner> fastest = runnerRepository.findFastest();
        assertThat(fastest.get().getName()).isEqualTo("runner1");

    }
}