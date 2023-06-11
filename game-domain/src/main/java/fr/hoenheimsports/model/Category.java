package fr.hoenheimsports.model;

import java.util.Objects;
import java.util.UUID;

public record Category(UUID id,String name) {
    public static final Category UNKNOWN = new Category(UUID.fromString("00000000-0000-0000-0000-000000000000"),"unknown");
    public Category {
        Objects.requireNonNull(id, "id should not be null");
        Objects.requireNonNull(name, "name should not be null");
    }
}


