package at.nacs.thymeleafsecurity.initialize;

import at.nacs.thymeleafsecurity.persistence.domain.Participant;
import at.nacs.thymeleafsecurity.persistence.repository.ParticipantRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.stream.Stream;

@Configuration
public class ParticipantInitializer {
  @Bean
  ApplicationRunner initializeParticipants(ParticipantRepository repository) {
    return args -> {
      Participant serife = new Participant();
      serife.setName("Serife");

      Participant bekir = new Participant();
      bekir.setName("Bekir");

      Stream.of(serife, bekir)
            .forEach(repository::save);
    };
  }

}
