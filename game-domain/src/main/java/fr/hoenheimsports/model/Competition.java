package fr.hoenheimsports.model;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public record Competition(UUID id, String name, List<Pool> pools) {
    public static final Competition UNKNOWN = new Competition(UUID.fromString("00000000-0000-0000-0000-000000000000"), "unknown", List.of(Pool.UNKNOWN));
    public Competition {
        Objects.requireNonNull(id,"id should be not null");
        Objects.requireNonNull(name,"name should be not null");
        List.copyOf(pools);
        Objects.requireNonNull(pools,"pool should be not null");
    }
}
