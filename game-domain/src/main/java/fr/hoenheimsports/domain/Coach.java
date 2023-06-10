package fr.hoenheimsports.domain;

import java.util.Objects;
import java.util.UUID;

public record Coach(UUID id, String name, PhoneNumber phoneNumber) implements Contributor{

    public Coach {
        Objects.requireNonNull(id, "id should not be null");
        Objects.requireNonNull(name, "name should not be null");
        Objects.requireNonNull(phoneNumber, "phoneNumber should not be null");
    }
}
