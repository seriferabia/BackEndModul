package at.nacs.fengshuiprofiler;

import at.nacs.fengshuiprofiler.controller.FengshuiClient;
import at.nacs.fengshuiprofiler.domain.Match;
import at.nacs.fengshuiprofiler.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FengshuiEndpoint {
    private final FengshuiClient client;

    @GetMapping("/profile/{name}/{birthday}")
    Profile get(@PathVariable String name, @PathVariable String birthday) {
        return client.getProfile(name, birthday);
    }

    @GetMapping("/match/{name1}/{birthday1}/{name2}/{birthday2}")
    Match get(@PathVariable String name1, @PathVariable String birthday1, @PathVariable String name2, @PathVariable String birthday2) {
        return client.getMatch(name1, birthday1, name2, birthday2);
    }
}
