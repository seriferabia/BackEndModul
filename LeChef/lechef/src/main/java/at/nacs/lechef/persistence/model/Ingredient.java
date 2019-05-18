package at.nacs.lechef.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "id")
public class Ingredient {
  @Id
  @GeneratedValue
  private Long id;

  private String name;

  private double amount;

  private String unit;

  private boolean bought;
}
