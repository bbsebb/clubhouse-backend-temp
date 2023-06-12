package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.Competition;
import fr.hoenheimsports.model.Pool;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

public class CompetitionBuilder {
    private UUID id;
    private String name;
    private List<Pool> pools = new ArrayList<>();

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
        this.pools.add(poolBuilder.build());
        return this;
    }

    public CompetitionBuilder withPool(Pool pool) {
        this.pools.add(pool);
        return this;
    }

    public Competition build() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        return new Competition(id, name, pools);
    }
}
