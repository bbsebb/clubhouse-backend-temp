package fr.hoenheimsports.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {
    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(NullPointerException.class, () -> new Competition(null, "Name", List.of(new Pool("0", "Pool"))));
        assertThrows(NullPointerException.class, () -> new Competition(UUID.randomUUID(), null, List.of(new Pool("0", "Pool"))));
        assertThrows(NullPointerException.class, () -> new Competition(UUID.randomUUID(), "Name", null));
    }
}