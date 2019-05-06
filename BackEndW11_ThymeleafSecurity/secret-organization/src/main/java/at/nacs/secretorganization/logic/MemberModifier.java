package at.nacs.secretorganization.logic;

import at.nacs.secretorganization.persistence.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class MemberModifier {

  private final PasswordEncoder encoder;

  public Member modify(Member member) {
    return Member.builder()
                 .username(member.getUsername())
                 .password(encoder.encode(member.getPassword()))
                 .authorities(Set.of("ROLE_USER"))
                 .build();
  }
}
