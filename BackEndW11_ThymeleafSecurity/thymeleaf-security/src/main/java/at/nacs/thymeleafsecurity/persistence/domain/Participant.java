package at.nacs.thymeleafsecurity.persistence.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Participant {
  @Id
  @GeneratedValue
  private Long id;

  @Column(unique = true)
  private String name;
}
