package netflix.springgraphql.domain.service;

import lombok.RequiredArgsConstructor;
import netflix.springgraphql.domain.type.Singer;
import netflix.springgraphql.domain.repository.SingerRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SingerService {

    private final SingerRepository singerRepository;

    public List<Singer> findAll() {
        return singerRepository.findAll();
    }

    public List<Singer> findByName(final String name) {
        return singerRepository.findByName(name);
    }

    public List<Singer> findBySameAge(final String name) {

        return findByName(name).stream().findFirst().map(targetSinger -> singerRepository.findAll().stream()
                .filter(singer -> singer.getAge().equals(targetSinger.getAge()))
                .collect(Collectors.toList())
        ).orElse(Collections.emptyList());
    }
}
