package at.nacs.secretorganization.logic;

import at.nacs.secretorganization.persistence.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MemberModifier {
  @Autowired
  PasswordEncoder encoder;

  public Member modify(Member member) {
    return Member.builder()
                 .username(member.getUsername())
                 .password(encoder.encode(member.getPassword()))
                 .authorities(Set.of("USER"))
                 .isAdmin(false)
                 .build();
  }
}
