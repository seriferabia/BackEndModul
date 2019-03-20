package at.nacs.webexample.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nutella")
public class NutellaEndpoint {
    @GetMapping
    public String getMessage(){
        return "Nutella is delicious!!!";
    }
}
