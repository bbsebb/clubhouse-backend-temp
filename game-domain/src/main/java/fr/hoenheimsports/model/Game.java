package fr.hoenheimsports.model;

import java.time.LocalDateTime;
import java.util.Objects;


public record Game(
        String code,
        Competition competition,
        Day day,
        Halle halle,
        Referees referees,
        Team homeTeam,
        Team visitingTeam,
        Score score,
        FDME fdme,
        LocalDateTime dateTime
) {
    public Game {
        Objects.requireNonNull(code, "code should not be null");
        Objects.requireNonNull(competition, "competition should not be null");
        Objects.requireNonNull(day, "day should not be null");
        Objects.requireNonNull(halle, "halle should not be null");
        Objects.requireNonNull(referees, "referees should not be null");
        Objects.requireNonNull(homeTeam, "homeTeam should not be null");
        Objects.requireNonNull(visitingTeam, "visitingTeam should not be null");
        Objects.requireNonNullElse(score, Score.DEFAULT);
        Objects.requireNonNull(fdme, "fdme should not be null");
        Objects.requireNonNull(dateTime, "dateTime should not be null");
    }
}
