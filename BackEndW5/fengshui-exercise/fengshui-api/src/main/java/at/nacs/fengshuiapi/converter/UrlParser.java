package at.nacs.fengshuiapi.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;

@Component
public class UrlParser {

    @Value("${fengshui.url}")
    String url;

    @Value("${fengshui.url-sign}")
    String urlSign;

    @Value("${fengshui.url-compatibility}")
    String urlCompatibility;

    public String buildUrl(String function, LocalDate birthday) {
        int year = birthday.getYear();
        int month = birthday.getMonthValue();
        int day = birthday.getDayOfMonth();
        UriComponents newUrl = UriComponentsBuilder
                .fromHttpUrl(url)
                .buildAndExpand(function, year, month, day);
        return newUrl.toString();
    }

    public String buildUrl(String function, String sign, String sign2) {
        UriComponents newUrl = UriComponentsBuilder
                .fromHttpUrl(urlSign)
                .buildAndExpand(function, sign, sign2);
        return newUrl.toString();
    }

    public String buildUrl(String function, LocalDate birthday, LocalDate birthday2) {
        int year = birthday.getYear();
        int month = birthday.getMonthValue();
        int day = birthday.getDayOfMonth();
        int year2 = birthday2.getYear();
        int month2 = birthday2.getMonthValue();
        int day2 = birthday2.getDayOfMonth();
        UriComponents newUrl = UriComponentsBuilder
                .fromHttpUrl(urlCompatibility)
                .buildAndExpand(function, year, month, day, year2, month2, day2);

        return newUrl.toString();
    }
}
