package at.nacs.userregistration.persistence.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

import static javax.persistence.TemporalType.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmationToken {
  @Id
  @GeneratedValue
  private Long id;

  @Builder.Default
  private String confirmationToken = UUID.randomUUID().toString();

  @Temporal(TIMESTAMP)
  private Date createdDate;

  @OneToOne
  private User user;
}
