package at.nacs.trickster.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@ConfigurationProperties("cups")
@RequiredArgsConstructor
public class CupClient {

    private final RestTemplate restTemplate;
    @Getter
    @Setter
    private Map<Integer, String> urls;

    public void removeAllCoins() {
        urls.keySet().stream()
                .forEach(e -> restTemplate.delete(urls.get(e)));
    }

    public void putCoin(Integer cupNumber) {
        String cupUrl = urls.get(cupNumber);
        restTemplate.put(cupUrl, Boolean.class);
    }

    public Boolean choose(int cupNumber) {
        String cupUrl = urls.get(cupNumber);
        return restTemplate.getForObject(cupUrl, Boolean.class);
    }

}
