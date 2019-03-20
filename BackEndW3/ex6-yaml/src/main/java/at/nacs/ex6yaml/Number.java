package at.nacs.ex6yaml;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Number {

    @Getter
    @Value("${exercise2.number}")
    private int number;
}
