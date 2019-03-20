package at.nacs.ex6properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Number {

    @Getter
    @Value("${exercise.number}")
    private int number;
}
