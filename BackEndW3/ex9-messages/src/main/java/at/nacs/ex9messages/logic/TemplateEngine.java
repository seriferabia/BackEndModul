package at.nacs.ex9messages.logic;

import at.nacs.ex9messages.template.Template;
import at.nacs.ex9messages.template.TemplateLoader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TemplateEngine {
    private final TemplateLoader templateLoader;
    private final Integer AMOUNT_OF_TEMPLATES = 4;

    public String returnMessage(String customerName) {
        return templateLoader.getTemplates().stream()
                .limit(AMOUNT_OF_TEMPLATES-1)
                .filter(e -> isRight(e, customerName))
                .map(template -> template.getMessage().replace("{name}", customerName))
                .findFirst().orElse(defaultMessage(customerName));
    }

    private String defaultMessage(String customerName) {
        int indexOfDefaultTemplate = AMOUNT_OF_TEMPLATES-1;
        return templateLoader.getTemplates().get(indexOfDefaultTemplate)
                .getMessage().replace("{name}", customerName);
    }

    private Boolean isRight(Template template, String name) {
        return template.getValidators().stream()
                .anyMatch(e -> name.contains(e));
    }
}
