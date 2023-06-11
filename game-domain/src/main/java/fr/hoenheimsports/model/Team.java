package fr.hoenheimsports.model;

import java.util.Objects;
import java.util.UUID;

public record Team(UUID id, Category category, Gender gender, int number,Club club,TeamsColor teamsColor, Coach coach) {
    public static final Team UNKNOWN = new Team(UUID.fromString("00000000-0000-0000-0000-000000000000"),Category.UNKNOWN,Gender.UNKNOWN,1,Club.UNKNOWN,TeamsColor.UNKNOWN,Coach.UNKNOWN);
    public Team {
        Objects.requireNonNull(id, "id should not be null");
        Objects.requireNonNull(category, "category should not be null");
        Objects.requireNonNull(gender, "gender should not be null");
        if(number<1) {
            throw new IllegalArgumentException("Team number should be greater than 0");
        }
        Objects.requireNonNull(club, "club should not be null");
        Objects.requireNonNull(teamsColor, "teamsColor should not be null");
        Objects.requireNonNull(coach, "name should not be null");
    }
}
