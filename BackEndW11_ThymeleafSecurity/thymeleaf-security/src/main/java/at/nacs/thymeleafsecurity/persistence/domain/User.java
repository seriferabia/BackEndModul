package at.nacs.thymeleafsecurity.persistence.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

  @ElementCollection(fetch = FetchType.EAGER)
  private Set<String> authorities = new HashSet<>();

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Participant> interested = new HashSet<>();
}
