package com.github.sparsick.springbootexample.hero.universum;
import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import java.util.Collection;

public abstract class HeroRepository {

    protected Collection<Hero> heroes;
    protected Counter counter;
    protected String name;
    public HeroRepository(MeterRegistry meterRegistry) {}

    String getName() { return name; }

    void addHero(Hero hero) {
        counter.increment();
        heroes.add(hero);
    }

    Collection<Hero> allHeroes()  {
        return heroes;
    }
}