package at.nacs.ex3thecursedcoin;


import org.springframework.stereotype.Component;

@Component

public class JackSparrow {
    private LegendaryCompass legendaryCompass;

    public JackSparrow(LegendaryCompass legendaryCompass) {
        this.legendaryCompass = legendaryCompass;
    }

    public String findCursedCoin() {
        return legendaryCompass.find() + CursedCoin.class.getSimpleName() + "!";
    }
}
