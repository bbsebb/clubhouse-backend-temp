package fr.hoenheimsports.model;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testConstructorWithNullParameters() {
        assertThrows(NullPointerException.class, () -> new Game(null, Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", null, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, null, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, null, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, null, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, null, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, null, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));

        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, null, LocalDateTime.now()));
        assertThrows(NullPointerException.class, () -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, null));
    }

    @Test
    public void testConstructorWithValidParameters() {
        assertDoesNotThrow(() -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, Score.DEFAULT, FDME.UNKNOWN, LocalDateTime.now()));
        assertDoesNotThrow(() -> new Game("code", Competition.UNKNOWN, Day.SINGLE_DAY_GAME, Halle.UNKNOWN, Referees.UNKNOWN, Team.UNKNOWN, Team.UNKNOWN, null, FDME.UNKNOWN, LocalDateTime.now()));
    }
}