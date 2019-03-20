package at.nacs.ex9templateinterface.logic;

import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    public void send(String message) {
        System.out.println(message);
    }
}
