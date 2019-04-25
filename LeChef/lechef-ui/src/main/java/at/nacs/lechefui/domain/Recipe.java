package at.nacs.lechefui.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
  @NotEmpty
  private String name;
  private String type;
  private String label;
  private String origin;
  private List<Ingredient> ingredients = new ArrayList<>();
}
