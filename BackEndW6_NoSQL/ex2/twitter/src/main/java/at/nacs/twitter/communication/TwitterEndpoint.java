package at.nacs.twitter.communication;

import at.nacs.twitter.logic.Twitter;
import at.nacs.twitter.persistence.Tweet;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tweets")
@RequiredArgsConstructor
public class TwitterEndpoint {
    private final Twitter twitter;

    @GetMapping
    List<Tweet> get(){
        return twitter.getAll();
    }

    @PostMapping
    Tweet post(@RequestBody Tweet tweet){
        return twitter.save(tweet);
    }

    @GetMapping("/{user}")
    List<Tweet> getOneUsersTweets(@PathVariable String user){
        return twitter.getOneUsersTweets(user);
    }

    @PutMapping("/{id}/likes")
    Optional<Tweet> putLike(@PathVariable String id){
        return twitter.updateLike(id);
    }

    @PutMapping("/{id}/comments")
    Optional<Tweet> putComment(@PathVariable String id, @RequestBody String comment){
        return twitter.updateComments(id, comment);
    }
}
