package netflix.springgraphql.domain.type;

import lombok.*;

@Builder
@Getter
public class Singer {
    private String name;

    private Integer age;

    private Gender gender;
}
