package at.nacs.ex6yaml;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ex6Configuration {
    @Bean
    ApplicationRunner saunaApplication(SaunaInformation info){
        return args -> {
            Sauna sauna = info.getSauna();
            System.out.println(sauna.getAvailableSeats()+" seats available with "+sauna.getTemperature()+" degree");
        };
    }

    @Bean
    ApplicationRunner danceSchoolApplication(DanceSchool school){
        return args -> {
            List<Ballerina> ballerinas = school.getBallerinas();
            ballerinas.stream()
                    .forEach(System.out::println);
        };
    }
}