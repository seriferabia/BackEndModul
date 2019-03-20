package at.nacs.weatherclient;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class WeatherClient {

    private final RestTemplate restTemplate;

    @Value("${weather.forecast.url}")
    private String url;

    public String getForecastForToday() {
        return "Client says: " + restTemplate.getForObject(url, String.class);
    }
}
