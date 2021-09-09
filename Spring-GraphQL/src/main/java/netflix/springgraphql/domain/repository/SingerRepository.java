package netflix.springgraphql.domain.repository;

import netflix.springgraphql.domain.type.Singer;

import java.util.List;

public interface SingerRepository {
    List<Singer> findAll();
    List<Singer> findByName(String name);
}
