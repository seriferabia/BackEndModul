package at.nacs.ex9templateinterface.configuration;

import at.nacs.ex9templateinterface.logic.CinemaMessageSender;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CinemaApplicationConfiguration {
    @Bean
    ApplicationRunner run(CinemaMessageSender messageSender){
        return args -> {
            messageSender.send();
        };
    }
}
