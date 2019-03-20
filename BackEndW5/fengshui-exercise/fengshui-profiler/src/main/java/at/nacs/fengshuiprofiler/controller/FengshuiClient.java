package at.nacs.fengshuiprofiler.controller;

import at.nacs.fengshuiprofiler.domain.Match;
import at.nacs.fengshuiprofiler.domain.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class FengshuiClient {
    private final RestTemplate restTemplate;

    @Value("${fengshui-api.url}")
    private String url;

    public Profile getProfile(String name, String birthday) {
        String urlSign = url + "/sign/" + birthday;
        String sign = restTemplate.getForObject(urlSign, String.class);
        return new Profile(name, LocalDate.parse(birthday), sign);
    }

    public Match getMatch(String name1, String birthday1, String name2, String birthday2) {
        String urlLove = url + "/compatibility/love/" + birthday1 + "/" + birthday2;
        String urlSign = url + "/compatibility/sign/" + birthday1 + "/" + birthday2;
        String loveCompatibility = restTemplate.getForObject(urlLove, String.class);
        String signCompatibility = restTemplate.getForObject(urlSign, String.class);
        Profile profile1 = getProfile(name1, birthday1);
        Profile profile2 = getProfile(name2, birthday2);
        return new Match(profile1, profile2, signCompatibility, loveCompatibility);
    }
}
