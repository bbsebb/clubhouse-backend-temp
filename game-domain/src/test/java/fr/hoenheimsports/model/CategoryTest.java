package fr.hoenheimsports.model;

import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {
    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(NullPointerException.class, () -> new Category(null, "Name"));
        assertThrows(NullPointerException.class, () -> new Category(UUID.randomUUID(), null));
    }
}