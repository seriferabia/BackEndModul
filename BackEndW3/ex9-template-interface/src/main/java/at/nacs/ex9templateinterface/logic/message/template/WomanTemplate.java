package at.nacs.ex9templateinterface.logic.message.template;

import at.nacs.ex9templateinterface.logic.NameReplacer;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("template.woman")
@RequiredArgsConstructor
public class WomanTemplate implements Template {
    private final NameReplacer nameReplacer;

    @Setter
    private List<String> identifiers;
    @Setter
    private String message;

    @Override
    public Boolean isValid(String name) {
        return identifiers.stream()
                .anyMatch(e -> name.startsWith(e));
    }

    @Override
    public String apply(String name) {
        return nameReplacer.replace(message, name);
    }
}
