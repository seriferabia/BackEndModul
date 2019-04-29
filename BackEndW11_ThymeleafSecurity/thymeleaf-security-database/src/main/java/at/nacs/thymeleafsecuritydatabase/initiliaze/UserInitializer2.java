package at.nacs.thymeleafsecuritydatabase.initiliaze;

import at.nacs.thymeleafsecuritydatabase.persistence.domain.User;
import at.nacs.thymeleafsecuritydatabase.persistence.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.stream.Stream;

@Configuration
public class UserInitializer2 {
  @Bean
  ApplicationRunner initializeUser(PasswordEncoder encoder, UserRepository repository) {
    return args -> {
      User user1 = createUser(encoder, "Mr. User", "user", "user", "USER");
      User user2 = createUser(encoder, "Mr. User2", "user2", "user2", "USER2");
      Stream.of(user1, user2)
            .forEach(user -> {
              if (repository.existsByUsername(user.getUsername())) {
                return;
              }
              repository.save(user);
            });
    };
  }

  private User createUser(PasswordEncoder encoder, String name, String username, String password, String authority) {
    return User.builder()
               .name(name)
               .username(username)
               .password(encoder.encode(password))
               .authorities(Set.of(authority))
               .build();
  }
}
