package at.nacs.ex9messages.template;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("cinema")
@Getter
@Setter
public class TemplateLoader {
    private List<Template> templates;
}

