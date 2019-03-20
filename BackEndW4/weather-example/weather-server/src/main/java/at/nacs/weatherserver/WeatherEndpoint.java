package at.nacs.weatherserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherEndpoint {

    @GetMapping
    String get(){
        return "The weather is awesome";
    }
}
