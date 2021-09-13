package netflix.springgraphql.domain.repository;

import netflix.springgraphql.domain.type.Follower;
import netflix.springgraphql.domain.type.Gender;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class SimpleFollowerRepository implements FollowerRepository {

    private Map<String, List<Follower>> followerMap = new HashMap<>();

    @PostConstruct
    void init() {
        followerMap.put("아이유", Arrays.asList(Follower.builder().nickname("아이유팬1").gender(Gender.FEMALE).build(),
                Follower.builder().nickname("아이유팬2").gender(Gender.MALE).build()));
    }

    @Override
    public List<Follower> findFollowerForSinger(final String name) {
        return followerMap.get(name);
    }

    @Override
    public List<Follower> findFollowers() {
        return followerMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }
}
