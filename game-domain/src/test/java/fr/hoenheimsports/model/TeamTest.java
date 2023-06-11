package fr.hoenheimsports.model;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {
    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(NullPointerException.class, () -> new Team(null, Category.UNKNOWN, Gender.MASCULINE, 1, Club.UNKNOWN, TeamsColor.UNKNOWN, Coach.UNKNOWN));
        assertThrows(NullPointerException.class, () -> new Team(UUID.randomUUID(), null, Gender.MASCULINE, 1, Club.UNKNOWN, TeamsColor.UNKNOWN, Coach.UNKNOWN));
        assertThrows(NullPointerException.class, () -> new Team(UUID.randomUUID(), Category.UNKNOWN, null, 1, Club.UNKNOWN, TeamsColor.UNKNOWN, Coach.UNKNOWN));
        assertThrows(IllegalArgumentException.class, () -> new Team(UUID.randomUUID(), Category.UNKNOWN, Gender.MASCULINE, 0, Club.UNKNOWN, TeamsColor.UNKNOWN, Coach.UNKNOWN));
        assertThrows(NullPointerException.class, () -> new Team(UUID.randomUUID(), Category.UNKNOWN, Gender.MASCULINE, 1, null, TeamsColor.UNKNOWN, Coach.UNKNOWN));
        assertThrows(NullPointerException.class, () -> new Team(UUID.randomUUID(), Category.UNKNOWN, Gender.MASCULINE, 1, Club.UNKNOWN, null, Coach.UNKNOWN));
        assertThrows(NullPointerException.class, () -> new Team(UUID.randomUUID(), Category.UNKNOWN, Gender.MASCULINE, 1, Club.UNKNOWN, TeamsColor.UNKNOWN, null));
    }
}