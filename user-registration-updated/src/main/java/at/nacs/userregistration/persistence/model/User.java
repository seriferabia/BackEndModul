package at.nacs.userregistration.persistence.model;

import at.nacs.userregistration.validator.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue
  private long id;

  @Column(unique = true)
  private String username;

  @ValidEmail
  private String email;

  private String password;
  private boolean isEnabled;
}
