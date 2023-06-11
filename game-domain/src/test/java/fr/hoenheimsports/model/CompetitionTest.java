package fr.hoenheimsports.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CompetitionTest {
    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(NullPointerException.class, () -> new Competition(null, "Name", new Pool("0", "Pool")));
        assertThrows(NullPointerException.class, () -> new Competition(UUID.randomUUID(), null, new Pool("0", "Pool")));
        assertThrows(NullPointerException.class, () -> new Competition(UUID.randomUUID(), "Name", null));
    }
}