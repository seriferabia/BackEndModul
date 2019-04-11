package at.nacs.trickster.communication;

import at.nacs.trickster.controller.Trickster;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TricksterEndpoint {
    private final Trickster trickster;

    @GetMapping("/play")
    String get(){
        return trickster.play();
    }

    @GetMapping("/choose/{number}")
    Boolean get(@PathVariable int number){
        return trickster.choose(number);
    }
}
