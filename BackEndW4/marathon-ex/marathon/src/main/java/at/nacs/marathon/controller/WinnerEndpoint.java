package at.nacs.marathon.controller;

import at.nacs.marathon.domain.Runner;
import at.nacs.marathon.persistence.RunnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/winner")
@RequiredArgsConstructor
public class WinnerEndpoint {

    private final RunnerRepository runnerRepository;


    @GetMapping
    Runner get() {
        return runnerRepository.findFastest().orElse(null);
    }
}
