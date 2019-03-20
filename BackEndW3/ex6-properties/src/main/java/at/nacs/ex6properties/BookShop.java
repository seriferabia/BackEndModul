package at.nacs.ex6properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@ConfigurationProperties("storage")
@Getter
@Setter
public class BookShop {

    private Map<String, Integer> bookshop = new HashMap<>();

}
