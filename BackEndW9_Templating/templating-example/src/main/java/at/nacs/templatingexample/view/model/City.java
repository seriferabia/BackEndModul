package at.nacs.templatingexample.view.model;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class City {

  @NotEmpty
  private String name;
}
