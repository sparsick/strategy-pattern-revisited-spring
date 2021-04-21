package com.github.sparsick.springbootexample.hero.universum;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public class DuplicateHeroRepository extends HeroRepository {

    public final static String NAME = "Duplicate;
    public final static String COUNTER_NAME = "hero.repository.duplicate";

    public DuplicateHeroRepository(MeterRegistry meterRegistry) {
        super(meterRegistry);
        name = NAME;
        counter = meterRegistry.counter(COUNTER_NAME);
        heroes = new ArrayList<>();
    }
}
