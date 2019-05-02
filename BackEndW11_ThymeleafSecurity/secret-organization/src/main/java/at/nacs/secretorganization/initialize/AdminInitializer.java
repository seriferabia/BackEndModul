package at.nacs.secretorganization.initialize;

import at.nacs.secretorganization.persistence.model.Member;
import at.nacs.secretorganization.persistence.repository.MemberRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class AdminInitializer {
  @Bean
  ApplicationRunner initializeAdmin(MemberRepository repository, PasswordEncoder encoder) {
    return args -> {
      Member admin = Member.builder()
                           .username("chief")
                           .password(encoder.encode("serife"))
                           .isAdmin(true)
                           .authorities(Set.of("ADMIN"))
                           .build();
      if (repository.existsByUsername(admin.getUsername())) {
        return;
      }
      repository.save(admin);
    };
  }
}
