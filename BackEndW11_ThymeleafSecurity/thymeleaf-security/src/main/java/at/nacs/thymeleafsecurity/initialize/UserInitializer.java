package at.nacs.thymeleafsecurity.initialize;

import at.nacs.thymeleafsecurity.persistence.domain.User;
import at.nacs.thymeleafsecurity.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.stream.Stream;

@Configuration
public class UserInitializer {
  @Bean
  ApplicationRunner initializeUsers(UserRepository repository, PasswordEncoder encoder) {
    return args -> {
      User user = User.builder()
                      .username("nacs")
                      .password(encoder.encode("nacs"))
                      .authorities(Set.of("USER"))
                      .build();
      User user2 = User.builder()
                       .username("google")
                       .password(encoder.encode("google"))
                       .authorities(Set.of("USER"))
                       .build();
      Stream.of(user, user2)
            .forEach(repository::save);
    };
  }
}
