package at.nacs.ex9templateinterface.logic;

import at.nacs.ex9templateinterface.logic.customer.CustomerLoader;
import at.nacs.ex9templateinterface.logic.message.TemplateEngine;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CinemaMessageSender {
    private final CustomerLoader customerLoader;
    private final TemplateEngine engine;
    private final MessageSender messageSender;

    public void send(){
        customerLoader.getNames().stream()
                .map(engine::getMessage)
                .forEach(messageSender::send);
    }
}
