package at.nacs.marathon.persistence;

import at.nacs.marathon.domain.Runner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
@Component
public class RunnerRepository {

    private List<Runner> runners = new ArrayList<>();

    public void add(Runner runner) {
        runners.add(runner);
    }

    public List<Runner> findAll() {
        return runners;
    }

    public Optional<Runner> findFastest(){
        return runners.stream()
                .min(Comparator.comparing(Runner::getTime));
    }
}
