package at.nacs.thymeleafsecurity.security;

import at.nacs.thymeleafsecurity.persistence.domain.User;
import at.nacs.thymeleafsecurity.persistence.repository.UserRepository;
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
