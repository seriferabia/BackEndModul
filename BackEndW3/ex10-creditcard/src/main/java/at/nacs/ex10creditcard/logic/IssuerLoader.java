package at.nacs.ex10creditcard.logic;

import at.nacs.ex10creditcard.domain.CreditCardIssuer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties("credit-card")
@Getter
@Setter
public class IssuerLoader {
    private List<CreditCardIssuer> issuers;

}
