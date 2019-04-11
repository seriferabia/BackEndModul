package at.nacs.twitter.communication;

import at.nacs.twitter.logic.Twitter;
import at.nacs.twitter.persistence.Tweet;
import at.nacs.twitter.persistence.TwitterRepository;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ConfigurationProperties("dataset")
class TwitterEndpointTest {
    @Autowired
    TestRestTemplate testRestTemplate;

    @Setter
    Tweet tweet;

    @SpyBean
    Twitter twitter;

    @MockBean
    TwitterRepository repository;

    private String url = "/tweets/";

    @Test
    void get() {
        testRestTemplate.getForObject(url, Tweet[].class);
        verify(twitter).getAll();
    }

    @Test
    void post() {
        testRestTemplate.postForObject(url, tweet, Tweet.class);
        verify(twitter).save(any());
    }

    @Test
    void getOneUsersTweets() {
        testRestTemplate.getForObject(url + "serife", Tweet[].class);
        verify(twitter).getOneUsersTweets(anyString());
    }

    @Test
    void putLike() {
        String urlLike = url + "anyId/likes";
        testRestTemplate.put(urlLike, tweet);
        verify(twitter).updateLike(anyString());
    }

    @Test
    void putComment() {
        String urlIdComments = url + "anyId/comments";
        testRestTemplate.put(urlIdComments, "new comment");
        verify(twitter).updateComments(anyString(), anyString());
    }
}