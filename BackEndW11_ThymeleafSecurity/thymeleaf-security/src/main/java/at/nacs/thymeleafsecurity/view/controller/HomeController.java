package at.nacs.thymeleafsecurity.view.controller;

import at.nacs.thymeleafsecurity.logic.Interests;
import at.nacs.thymeleafsecurity.persistence.domain.Participant;
import at.nacs.thymeleafsecurity.persistence.repository.ParticipantRepository;
import at.nacs.thymeleafsecurity.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
  private final Interests interests;
  private final ParticipantRepository participantRepository;

  @GetMapping
  String page() {
    return "home";
  }

  @PostMapping("/interested/{id}")
  String interested(@PathVariable Long id, @AuthenticationPrincipal UserPrincipal principal) {
    Long userId = principal.getUser().getId();
    Long participantId = id;
    interests.markAsInterested(userId, participantId);
    return "redirect:/";
  }

  @PostMapping("/notinterested/{id}")
  String notInterested(@PathVariable Long id, @AuthenticationPrincipal UserPrincipal principal) {
    Long userId = principal.getUser().getId();
    Long participantId = id;
    interests.markAsNotInterested(userId, participantId);
    return "redirect:/";
  }

  @ModelAttribute("participants")
  List<Participant> participants() {
    return participantRepository.findAll();
  }

  @ModelAttribute("interestedParticipants")
  List<Participant> interestedParticipants(@AuthenticationPrincipal UserPrincipal principal) {
    Long userId = principal.getUser().getId();
    return interests.getInterestedParticipants(userId);
  }
}
