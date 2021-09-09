package netflix.springgraphql.domain.repository;

import netflix.springgraphql.domain.type.Gender;
import netflix.springgraphql.domain.type.Singer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class SimpleSingerRepository implements SingerRepository {

    private List<Singer> singerList = new ArrayList<>();
    private Map<String, Singer> singerMap = new HashMap<>();

    @PostConstruct
    void init() {
        singerList = List.of(
                Singer.builder()
                        .name("아이유")
                        .age(29)
                        .gender(Gender.FEMALE)
                        .build(),
                Singer.builder()
                        .name("피오")
                        .age(29)
                        .gender(Gender.MALE)
                        .build(),
                Singer.builder()
                        .name("백아연")
                        .age(29)
                        .gender(Gender.FEMALE)
                        .build(),
                Singer.builder()
                        .name("지수")
                        .age(27)
                        .gender(Gender.FEMALE)
                        .build()
        );
    }

    @Override
    public List<Singer> findAll() {
        return singerList;
    }

    @Override
    public List<Singer> findByName(String name) {
        return findAll().stream().filter(s -> s.getName().contains(name)).collect(Collectors.toList());
    }
}
