package at.nacs.dutchman;

import at.nacs.dutchman.domain.DeadMansChest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class DeadMansChestEndpointTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    String url = "/deadmanschest";

    @Test
    void getChest() {
        DeadMansChest chest = testRestTemplate.getForObject(url, DeadMansChest.class);
        Assertions.assertThat(chest.getItem()).isEqualTo("Skull");
    }

}