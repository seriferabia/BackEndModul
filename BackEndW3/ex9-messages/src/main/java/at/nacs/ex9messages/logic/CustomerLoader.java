package at.nacs.ex9messages.logic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("customer")
@Getter
@Setter
public class CustomerLoader {
    private List<String> names;
}
