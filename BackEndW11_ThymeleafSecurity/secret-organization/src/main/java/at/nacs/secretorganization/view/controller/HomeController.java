package at.nacs.secretorganization.view.controller;

import at.nacs.secretorganization.logic.MemberModifier;
import at.nacs.secretorganization.persistence.model.Member;
import at.nacs.secretorganization.persistence.repository.MemberRepository;
import at.nacs.secretorganization.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
  private final MemberRepository repository;
  private final MemberModifier modifier;


  @GetMapping
  String page() {
    return "home";
  }

  @RolesAllowed("ROLE_ADMIN")
  @PostMapping
  String post(@Valid Member member, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    repository.save(modifier.modify(member));
    return "redirect:/";
  }

  @ModelAttribute("member")
  Member member() {
    return new Member();
  }

  @ModelAttribute("members")
  List<Member> members() {
    return repository.findAll();
  }

  @ModelAttribute("isAdmin")
  boolean isAdmin(@AuthenticationPrincipal UserPrincipal principal) {
    return principal.getMember().getAuthorities().contains("ROLE_ADMIN");
  }

  @ModelAttribute("loggedMember")
  String loggedUserName(@AuthenticationPrincipal UserPrincipal principal) {
    return principal.getMember().getUsername();
  }
}
