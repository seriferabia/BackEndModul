package at.nacs.ex9messages.template;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TemplateLoaderTest {
    @Autowired
    TemplateLoader templateLoader;

    @Test
    void testGetTemplates() {
        templateLoader.getTemplates().stream()
                .forEach(System.out::println);
    }
}