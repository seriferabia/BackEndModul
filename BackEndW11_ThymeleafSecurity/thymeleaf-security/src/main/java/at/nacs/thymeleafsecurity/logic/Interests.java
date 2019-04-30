package at.nacs.thymeleafsecurity.logic;

import at.nacs.thymeleafsecurity.persistence.domain.Participant;
import at.nacs.thymeleafsecurity.persistence.domain.User;
import at.nacs.thymeleafsecurity.persistence.repository.ParticipantRepository;
import at.nacs.thymeleafsecurity.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class Interests {

  private final UserRepository userRepository;
  private final ParticipantRepository participantRepository;

  public void markAsInterested(Long userId, Long participantId) {
    Optional<User> oUser = userRepository.findById(userId);
    Optional<Participant> oParticipant = participantRepository.findById(participantId);
    if (oUser.isEmpty() || oParticipant.isEmpty()) {
      return;
    }
    User user = oUser.get();
    Participant participant = oParticipant.get();
    user.getInterested().add(participant);
    userRepository.save(user);
  }

  public void markAsNotInterested(Long userId, Long participantId) {
    Optional<User> oUser = userRepository.findById(userId);
    Optional<Participant> oParticipant = participantRepository.findById(participantId);
    if (oUser.isEmpty() || oParticipant.isEmpty()) {
      return;
    }
    User user = oUser.get();
    Participant participant = oParticipant.get();
    user.getInterested().remove(participant);
    userRepository.save(user);
  }

  public List<Participant> getInterestedParticipants(Long userId) {
    Optional<User> oUser = userRepository.findById(userId);
    if (oUser.isEmpty()) {
      return new ArrayList<>();
    }
    return oUser.get()
                .getInterested()
                .stream()
                .collect(toList());
  }
}
