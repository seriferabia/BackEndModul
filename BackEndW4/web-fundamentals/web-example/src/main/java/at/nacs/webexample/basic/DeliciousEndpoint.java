package at.nacs.webexample.basic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/delicious")
public class DeliciousEndpoint {

    @GetMapping
    String delicious(){
        return "Foods are delicious";
    }

    @GetMapping("/nutella")
    String nutellaIsDelicious(){
        return "Nutella is always delicious";
    }

    @GetMapping("/{name}")
    String whatIsDelicious(@PathVariable String name){
        return name + " is also delicious";
    }
}
