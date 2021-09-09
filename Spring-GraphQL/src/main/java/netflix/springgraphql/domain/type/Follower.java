package netflix.springgraphql.domain.type;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Follower {
    private String nickname;
}