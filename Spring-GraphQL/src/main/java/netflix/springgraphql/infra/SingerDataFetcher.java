package netflix.springgraphql.infra;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsData;
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment;
import com.netflix.graphql.dgs.InputArgument;
import lombok.RequiredArgsConstructor;
import netflix.springgraphql.domain.service.FollowerService;
import netflix.springgraphql.domain.type.Follower;
import netflix.springgraphql.domain.type.Singer;
import netflix.springgraphql.domain.service.SingerService;
import netflix.springgraphql.exception.NotFoundSingerRuntimeException;
import org.springframework.util.StringUtils;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class SingerDataFetcher {

    private final SingerService singerService;
    private final FollowerService followerService;

    @DgsData(parentType = "Query", field = "singers")
    public List<Singer> findSingers(@InputArgument("name") String name) {
        if(StringUtils.isEmpty(name)) {
            return singerService.findAll();
        }
        return singerService.findByName(name);
    }

    @DgsData(parentType = "Query", field = "singersBySameAge")
    public List<Singer> findSingersBySameAge(@InputArgument("name") String name) {
        if(StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }

        List<Singer> singers = singerService.findBySameAge(name);
        if(singers.isEmpty()) {
            throw new NotFoundSingerRuntimeException();
        }
        return singers;

    }

    @DgsData(parentType = "Singer", field = "followers")
    public List<Follower> followers(DgsDataFetchingEnvironment dfe) {

        Singer singer = dfe.getSource();
        return followerService.followersForSinger(singer.getName());
    }

    @DgsData(parentType = "Query", field = "followers")
    public List<Follower> findFollowers(@InputArgument("name") String name){
        if(StringUtils.isEmpty(name)) {
            return followerService.findAll();
        }
        return followerService.followersForSinger(name);
    }
}

