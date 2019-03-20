package at.nacs.polo.logic;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Response {

    @Value("${response.marco}")
    String polo;

    @Value("${response.others}")
    String answerToOthers;

    public String answerTo(String message) {
        if (message.equalsIgnoreCase("Marco")) {
            return polo;
        }
        return answerToOthers;
    }
}
