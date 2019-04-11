package at.nacs.twitter.logic;

import at.nacs.twitter.persistence.Tweet;
import at.nacs.twitter.persistence.TwitterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class Twitter {

    private final TwitterRepository twitterRepository;

    public List<Tweet> getAll() {
        return twitterRepository.findByOrderByTimestampDesc();
    }

    public Tweet save(Tweet tweet) {
        tweet.setTimestamp(LocalDateTime.now());
        return twitterRepository.save(tweet);
    }

    public List<Tweet> getOneUsersTweets(String user) {
        return twitterRepository.findAllByUserOrderByTimestamp(user);
//        List<Tweet> tweets = twitterRepository.findByUser(user);
//        return tweets.stream()
//                .sorted(Comparator.comparing(Tweet::getTimestamp).reversed())
//                .collect(Collectors.toList());
    }

    public Optional<Tweet> updateLike(String id) {
        Optional<Tweet> tweet = twitterRepository.findById(id);
        if (tweet.isPresent()){
            int updatedLikes = tweet.get().getLikes() + 1;
            tweet.get().setLikes(updatedLikes);
            twitterRepository.save(tweet.get());
            return tweet;
        }
        return Optional.empty();
    }

    public Optional<Tweet> updateComments(String id, String comment) {
        Optional<Tweet> tweet = twitterRepository.findById(id);
        if (tweet.isPresent()){
            tweet.get().getComments().add(comment);
            twitterRepository.save(tweet.get());
            return tweet;
        }
        return Optional.empty();
    }
}
