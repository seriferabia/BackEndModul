package at.nacs.secretorganization.view.controller;

import at.nacs.secretorganization.logic.MemberModifier;
import at.nacs.secretorganization.persistence.model.Member;
import at.nacs.secretorganization.persistence.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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

  @Autowired
  PasswordEncoder encoder;

  @GetMapping
  String page() {
    return "home";
  }

  @RolesAllowed("ADMIN")
  @PostMapping
  String post(@Valid Member member, BindingResult result) {
    if (result.hasErrors()) {
      return page();
    }
    repository.save(modifier.modify(member));
    return "redirect:/";
  }

  @ModelAttribute("members")
  List<Member> members() {
    return repository.findAll();
  }
}
