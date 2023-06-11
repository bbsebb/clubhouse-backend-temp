package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.Competition;
import fr.hoenheimsports.model.Pool;

import java.util.UUID;
import java.util.function.Consumer;

public class CompetitionBuilder {
    private UUID id;
    private String name;
    private Pool pool;

    public CompetitionBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public CompetitionBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CompetitionBuilder withPool(Consumer<PoolBuilder> poolBuilderFunction) {
        PoolBuilder poolBuilder = new PoolBuilder();
        poolBuilderFunction.accept(poolBuilder);
        this.pool = poolBuilder.build();
        return this;
    }

    public CompetitionBuilder withPool(Pool pool) {
        this.pool = pool;
        return this;
    }

    public Competition build() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        return new Competition(id, name, pool);
    }
}
