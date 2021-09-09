package netflix.springgraphql.domain.repository;

import netflix.springgraphql.domain.type.Follower;

import java.util.List;

public interface FollowerRepository {
    List<Follower> findFollowerForSinger(String name);
}
