package at.nacs.ex9templateinterface.logic.message;

import at.nacs.ex9templateinterface.logic.message.template.Template;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.function.Supplier;

@RequiredArgsConstructor
public class TemplateEngine {
    private final List<Template> templates;
    
    public String getMessage(String name){
        return templates.stream()
                .filter(e->e.isValid(name))
                .map(e->e.apply(name))
                .findFirst().orElseThrow(templateNotFound(name));
    }

    private Supplier<IllegalArgumentException> templateNotFound(String name) {
        return () -> new IllegalArgumentException("No template found for name: " + name);
    }
}
