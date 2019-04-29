package at.nacs.thymeleafsecuritydatabase.security;

import at.nacs.thymeleafsecuritydatabase.persistence.domain.User;
import at.nacs.thymeleafsecuritydatabase.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<User> user = userRepository.findOneByUsername(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException(username);
    }
    return new UserPrincipal(user.get());
  }
}
