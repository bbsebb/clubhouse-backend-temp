package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.Category;

import java.util.UUID;

public class CategoryBuilder {
    private UUID id;
    private String name;

    public CategoryBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public CategoryBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public Category build() {
        if (id == null) {
            id = UUID.randomUUID();
        }
        return new Category(id, name);
    }
}
