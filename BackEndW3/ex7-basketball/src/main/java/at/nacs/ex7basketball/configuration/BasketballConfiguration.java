package at.nacs.ex7basketball.configuration;

import at.nacs.ex7basketball.logic.Tournament;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasketballConfiguration {

    @Bean
    ApplicationRunner tournamentApplication(Tournament tournament){
        return args -> {
            tournament.introduceTeams();
            tournament.displayMatchResults();

        };
    }
}
