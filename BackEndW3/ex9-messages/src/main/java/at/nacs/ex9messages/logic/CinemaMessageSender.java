package at.nacs.ex9messages.logic;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CinemaMessageSender {
    private final CustomerLoader customerLoader;
    private final TemplateEngine engine;
    private final TextMessageSender messageSender;

    public void messages() {
        customerLoader.getNames().stream()
                .map(name -> engine.returnMessage(name))
                .forEach(message -> messageSender.send(message));

    }

}
