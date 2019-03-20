package at.nacs.ex7basketball.domain;

import at.nacs.ex7basketball.domain.BasketballTeam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("tournament")
@Getter
@Setter
public class TeamLoader {
    private List<BasketballTeam> teams;
}
