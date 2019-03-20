package at.nacs.ex9messages.logic;

import org.springframework.stereotype.Component;

@Component
public class TextMessageSender {
    public void send(String message) {
        System.out.println(message);
    }

}
