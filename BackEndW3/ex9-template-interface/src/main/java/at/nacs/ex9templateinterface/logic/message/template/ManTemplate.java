package at.nacs.ex9templateinterface.logic.message.template;

import at.nacs.ex9templateinterface.logic.NameReplacer;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("template.man")
@RequiredArgsConstructor
public class ManTemplate implements Template {
    private NameReplacer nameReplacer;

    @Setter
    private String identifier;
    @Setter
    private String message;

    @Override
    public Boolean isValid(String name) {
        return name.startsWith(identifier);
    }

    @Override
    public String apply(String name) {
        return nameReplacer.replace(message,name);
    }
}
