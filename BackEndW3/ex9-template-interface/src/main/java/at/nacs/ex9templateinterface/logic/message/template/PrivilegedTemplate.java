package at.nacs.ex9templateinterface.logic.message.template;

import at.nacs.ex9templateinterface.logic.NameReplacer;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Stream;

@Component
@ConfigurationProperties("template.privileged")
@RequiredArgsConstructor
public class PrivilegedTemplate implements Template {
    private NameReplacer nameReplacer;

    @Setter
    private String identifier;
    @Setter
    private String message;


    @Override
    public Boolean isValid(String name) {
        return Stream.of(name.split(" "))
                .anyMatch(e-> Objects.equals(e,identifier));
    }

    @Override
    public String apply(String name) {
        return nameReplacer.replace(message,name);
    }
}
