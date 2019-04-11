package at.nacs.twitter.logic;

import at.nacs.twitter.persistence.Tweet;
import at.nacs.twitter.persistence.TwitterRepository;
import lombok.Setter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.NONE;

@SpringBootTest(webEnvironment = NONE)
@ConfigurationProperties("dataset")
class TwitterTest {
    @Autowired
    Twitter twitter;

    @Autowired
    TwitterRepository repository;

    @Setter
    List<Tweet> tweets;

    @Setter
    Tweet extra;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
        repository.saveAll(tweets);
    }

    @Test
    void testGetAll() {
        int actualSize = twitter.getAll().size();
        assertThat(actualSize).isEqualTo(2);
    }

    @Test
    void testPost() {
        Tweet posted = twitter.save(extra);
        assertThat(posted.getId()).isNotBlank();
        assertThat(posted.getTimestamp()).isBefore(LocalDateTime.now());
    }

    @Test
    void testGetOneUsersTweets() {
        List<Tweet> tweets = twitter.getOneUsersTweets("serife");
        int actual = tweets.size();
        assertThat(actual).isEqualTo(1);

        tweets = twitter.getOneUsersTweets("unknown");
        actual = tweets.size();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void testUpdateLikes() {
        Tweet serifesTweet = twitter.getOneUsersTweets("serife").get(0);
        int likesBefore = serifesTweet.getLikes();
        Optional<Tweet> tweet = twitter.updateLike(serifesTweet.getId());
        assertThat(tweet.get().getLikes()).isEqualTo(likesBefore + 1);
    }

    @Test
    void testUpdateComments() {
        Tweet serifesTweet = twitter.getOneUsersTweets("serife").get(0);
        Optional<Tweet> tweet = twitter.updateComments(serifesTweet.getId(), "yess!");
        assertThat(tweet.get().getComments().size()).isNotEqualTo(0);
        assertThat(tweet.get().getComments()).contains("yess!");
    }
}