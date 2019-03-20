package at.nacs.webexample.car;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarEndpoint {
    private Car car;

    @GetMapping
    Car get(){
        return car;
    }

    @PutMapping
    Car replace(@RequestBody Car newCar){
        car=newCar;
        return newCar;
    }
}
