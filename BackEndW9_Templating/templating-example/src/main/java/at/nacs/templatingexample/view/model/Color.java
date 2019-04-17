package at.nacs.templatingexample.view.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class Color {

  @NotEmpty
  private String name;

  @NotNull
  @Min(1)
  @Max(5)
  private int rating;
}
