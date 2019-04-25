package at.nacs.lechefui.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {
  @NotEmpty
  private String name;
  private String unit;
  private double amount;
}
