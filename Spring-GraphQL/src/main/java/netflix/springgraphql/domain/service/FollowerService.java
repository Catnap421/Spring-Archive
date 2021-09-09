package netflix.springgraphql.domain.service;

import lombok.RequiredArgsConstructor;
import netflix.springgraphql.domain.repository.FollowerRepository;
import netflix.springgraphql.domain.type.Follower;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowerService {

    private final FollowerRepository followerRepository;

    public List<Follower> followersForSinger(final String name) {
        return followerRepository.findFollowerForSinger(name);
    }
}