package at.nacs.ex9messages.template;

import lombok.Data;

import java.util.List;

@Data
public class Template {
    private List<String> validators;
    private String message;
}
