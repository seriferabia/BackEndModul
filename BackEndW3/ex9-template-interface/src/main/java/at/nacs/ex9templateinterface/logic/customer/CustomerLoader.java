package at.nacs.ex9templateinterface.logic.customer;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("customer")
public class CustomerLoader {

    @Setter
    @Getter
    private List<String> names;
}
