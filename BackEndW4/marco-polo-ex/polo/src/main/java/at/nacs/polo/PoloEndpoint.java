package at.nacs.polo;

import at.nacs.polo.logic.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/polo")
@RequiredArgsConstructor
public class PoloEndpoint {

    private final Response response;

    @PostMapping
    String returnMessage(@RequestBody String message) {
       return response.answerTo(message);
    }
}
