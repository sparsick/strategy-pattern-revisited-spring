package com.github.sparsick.springbootexample.hero.universum;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Repository;
import java.util.HashSet;
import javax.annotation.PostConstruct;

@Repository
public class UniqueHeroRepository extends HeroRepository {

    public final static String NAME = "Unique";
    public final static String COUNTER_NAME = "hero.repository.unique";

    public UniqueHeroRepository(MeterRegistry meterRegistry) {
        super(meterRegistry);
        name = NAME;
        counter = meterRegistry.counter(COUNTER_NAME);
        heroes = new HashSet<>();
    }

    @PostConstruct
    public void init() {
        heroes.add(new Hero("Batman", "Gotham City", ComicUniversum.DC_COMICS));
        heroes.add(new Hero("Superman", "Metropolis", ComicUniversum.DC_COMICS));
    }
}
