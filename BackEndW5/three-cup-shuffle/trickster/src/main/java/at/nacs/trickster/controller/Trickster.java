package at.nacs.trickster.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class Trickster {

    private final CupClient cupClient;

    @Value("${cups.amount}")
    private int numberOfCups;


    public String play() {
        cupClient.removeAllCoins();
        int cup = new Random().nextInt(numberOfCups);
        cupClient.putCoin(cup);
        return "The game has started";
    }

    public Boolean choose(int number) {
        return cupClient.choose(number);
    }
}
