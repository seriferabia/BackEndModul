package at.nacs.ex6properties;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Word {

    @Getter
    @Value("${exercise.word}")
    private String word;
}

