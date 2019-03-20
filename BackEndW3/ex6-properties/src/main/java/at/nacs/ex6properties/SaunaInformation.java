package at.nacs.ex6properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("information")
@Getter
@Setter
public class SaunaInformation {
    private Sauna sauna;

}
