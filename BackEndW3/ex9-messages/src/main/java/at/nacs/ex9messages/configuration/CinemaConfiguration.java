package at.nacs.ex9messages.configuration;

import at.nacs.ex9messages.logic.CinemaMessageSender;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaConfiguration {
    @Bean
    ApplicationRunner messageApplication(CinemaMessageSender messageSender) {
        return args -> {
            messageSender.messages();
        };
    }
}
