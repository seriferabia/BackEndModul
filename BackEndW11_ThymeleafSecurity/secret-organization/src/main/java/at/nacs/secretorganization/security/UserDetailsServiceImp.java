package at.nacs.secretorganization.security;

import at.nacs.secretorganization.persistence.model.Member;
import at.nacs.secretorganization.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

  private final MemberRepository repository;

  @Override
  public UserDetails loadUserByUsername(String username) {
    Optional<Member> member = repository.findOneByUsername(username);
    if (member.isEmpty()) {
      throw new UsernameNotFoundException(username);
    }
    return new UserPrincipal(member.get());
  }
}
