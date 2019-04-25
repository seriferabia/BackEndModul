package at.nacs.lechef.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Recipe {
  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;

  private String type;
  private String label;
  private String origin;

  @LazyCollection(LazyCollectionOption.FALSE)
  @ManyToMany(cascade = CascadeType.ALL)
  private List<Ingredient> ingredients = new ArrayList<>();
}
