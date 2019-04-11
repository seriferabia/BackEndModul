package at.nacs.twitter.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TwitterRepository extends MongoRepository<Tweet, String> {

    List<Tweet> findByOrderByTimestampDesc();
    List<Tweet> findAllByUserOrderByTimestamp(String user);
//    List<Tweet> findByUser(String user);
}
