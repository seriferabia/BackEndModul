package at.nacs.fengshuiapi.controller;

import at.nacs.fengshuiapi.converter.SignConverter;
import at.nacs.fengshuiapi.converter.UrlParser;
import at.nacs.fengshuiapi.domain.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class FengshuiClient {
    private final RestTemplate restTemplate;
    private final UrlParser urlParser;
    private final SignConverter converter;

    @Value("${function.sign-of-year}")
    private String sign;

    @Value("${function.sign-compatibility}")
    private String signCompatibility;

    @Value("${function.love-compatibility}")
    private String loveCompatibility;


    public String getSign(LocalDate birthday) {
        String url = urlParser.buildUrl(sign, birthday);
        Result result = restTemplate.getForObject(url, Result.class);
        return result.getResult();
    }

    public String getLoveCompatibility(LocalDate birthday1, LocalDate birthday2) {
        String url = urlParser.buildUrl(loveCompatibility, birthday1, birthday2);
        Result result = restTemplate.getForObject(url, Result.class);
        return result.getResult();
    }

    public String getSignCompatibility(LocalDate birthday1, LocalDate birthday2) {
        String sign1 = converter.convertSign(getSign(birthday1));
        String sign2 = converter.convertSign(getSign(birthday2));
        String url = urlParser.buildUrl(signCompatibility, sign1, sign2);
        Result result = restTemplate.getForObject(url, Result.class);
        return result.getResult();
    }
}
