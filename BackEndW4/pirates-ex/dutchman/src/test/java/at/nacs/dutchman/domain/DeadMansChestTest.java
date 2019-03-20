package at.nacs.dutchman.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

@SpringBootTest(webEnvironment = NONE)
class DeadMansChestTest {

    @Autowired
    DeadMansChest deadMansChest;

    @Test
    void getItem() {

        assertThat(deadMansChest.getItem()).isEqualTo(null);

    }

    @Test
    void setItem() {
        deadMansChest.setItem("Gold");
        assertThat(deadMansChest.getItem()).isEqualTo("Gold");
    }
}