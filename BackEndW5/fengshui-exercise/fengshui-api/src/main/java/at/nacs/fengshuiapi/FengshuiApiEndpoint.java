package at.nacs.fengshuiapi;

import at.nacs.fengshuiapi.controller.FengshuiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FengshuiApiEndpoint {
    private final FengshuiClient fengshuiClient;

    @GetMapping("/sign/{birthday}")
    String get(@PathVariable LocalDate birthday) {
        return fengshuiClient.getSign(birthday);
    }

    @GetMapping("/compatibility/love/{birthday1}/{birthday2}")
    String get(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return fengshuiClient.getLoveCompatibility(birthday1, birthday2);
    }

    @GetMapping("/compatibility/sign/{birthday1}/{birthday2}")
    String getSignCompatibility(@PathVariable LocalDate birthday1, @PathVariable LocalDate birthday2) {
        return fengshuiClient.getSignCompatibility(birthday1, birthday2);
    }
}
