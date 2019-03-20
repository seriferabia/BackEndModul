package at.nacs.fengshuiapi.converter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@ConfigurationProperties("chinese")
public class SignConverter {

    @Getter
    @Setter
    private Map<String, String> signs;

    public String convertSign(String signName) {
        return signs.get(signName);
    }
}