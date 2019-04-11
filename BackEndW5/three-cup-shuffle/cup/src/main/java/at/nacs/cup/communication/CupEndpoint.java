package at.nacs.cup.communication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coin")
public class CupEndpoint {

    @Value("${cup.status}")
    private Boolean isCupHere;

    @GetMapping
    Boolean get() {
        return isCupHere;
    }

    @PutMapping
    void put() {
        isCupHere = true;
    }

    @DeleteMapping
    void delete() {
        isCupHere = false;
    }
}
