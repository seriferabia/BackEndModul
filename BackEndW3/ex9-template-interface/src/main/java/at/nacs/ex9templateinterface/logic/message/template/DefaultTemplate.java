package at.nacs.ex9templateinterface.logic.message.template;

import at.nacs.ex9templateinterface.logic.NameReplacer;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("template.default")
@RequiredArgsConstructor
public class DefaultTemplate implements Template {
    private final NameReplacer nameReplacer;

    @Setter
    private String message;

    @Override
    public Boolean isValid(String name) {
        return !name.startsWith("Mrs.") &&
                !name.startsWith("Ms") &&
                !name.startsWith("Mr.") &&
                !name.contains("Threepwood");
    }

    @Override
    public String apply(String name) {
        return nameReplacer.replace(message,name);
    }
}
