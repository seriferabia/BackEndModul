package at.nacs.templatingexample.view.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ValidatedMessage {

  @NotEmpty
  private String text;

  @NotNull
  @Min(2)
  private Integer number;
}
