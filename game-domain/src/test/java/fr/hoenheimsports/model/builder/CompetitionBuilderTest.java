package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.Competition;
import fr.hoenheimsports.model.Pool;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionBuilderTest {

    @Test
    public void testBuildWithId() {
        UUID id = UUID.randomUUID();
        String name = "Competition";
        Pool pool = Pool.UNKNOWN;

        Competition competition = new CompetitionBuilder()
                .withId(id)
                .withName(name)
                .withPool(pool)
                .build();

        Assertions.assertEquals(id, competition.id());
        Assertions.assertEquals(name, competition.name());
        Assertions.assertEquals(pool, competition.pool());
    }

    @Test
    public void testBuildWithoutId() {
        String name = "Competition";
        Pool pool = Pool.UNKNOWN;

        Competition competition = new CompetitionBuilder()
                .withName(name)
                .withPool(pool)
                .build();

        Assertions.assertNotNull(competition.id());
        Assertions.assertEquals(name, competition.name());
        Assertions.assertEquals(pool, competition.pool());
    }

    @Test
    public void testBuildWithPoolConsumer() {
        UUID id = UUID.randomUUID();
        String name = "Competition";
        String poolNumber = "A";
        String poolName = "Pool A";

        Competition competition = new CompetitionBuilder()
                .withId(id)
                .withName(name)
                .withPool(poolBuilder -> poolBuilder
                        .withNumber(poolNumber)
                        .withName(poolName))
                .build();

        Assertions.assertEquals(id, competition.id());
        Assertions.assertEquals(name, competition.name());
        Assertions.assertEquals(poolNumber, competition.pool().number());
        Assertions.assertEquals(poolName, competition.pool().name());
    }
}