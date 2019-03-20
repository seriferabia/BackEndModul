package at.nacs.webexample.basic2;

import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/cakes")
public class CakeEndpoint {
    private Set<String> cakes = new HashSet<>();

    @GetMapping
    Set<String> get() {
        return cakes;
    }

    @GetMapping("/{type}")
    String getOneCake(@PathVariable String type) {
        if (cakes.contains(type)) {
            return "Yeess!! We have " + type;
        }
        return "Sorry, we do not have it";
    }

    @PostMapping
    String add(@RequestBody String type) {
        cakes.add(type);
        return type + " is added";
    }

    @DeleteMapping
    void delete(){
        cakes.clear();
    }

    @DeleteMapping("/{type}")
    void deleteOneCake(@PathVariable String type){
        cakes.remove(type);
    }
}
