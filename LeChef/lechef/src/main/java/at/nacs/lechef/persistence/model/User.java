package at.nacs.lechef.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.CascadeType.ALL;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String username;

  private String password;

  @OneToOne(cascade = ALL)
  private Kitchen kitchen;

  @OneToOne(cascade = ALL, fetch = FetchType.EAGER)
  @Builder.Default
  private ShoppingList shoppingList = new ShoppingList();
}
