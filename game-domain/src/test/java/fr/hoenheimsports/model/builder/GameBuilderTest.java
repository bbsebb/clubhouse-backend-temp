package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.print.DocFlavor;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GameBuilderTest {

    @Test
    public void testBuild_withCode() {
        String code = "G001";
        Game game = new GameBuilder()
                .withCode(code)
                .build();

        Assertions.assertEquals(code, game.code());
    }

    @Test
    public void testBuild_withCompetition_Consumer() {
        Competition competition = new CompetitionBuilder()
                .withId(UUID.randomUUID())
                .withName("Ligue des Champions")
                .build();

        Game game = new GameBuilder()
                .withCompetition(builder -> builder
                        .withId(UUID.randomUUID())
                        .withName("Ligue des Champions"))
                .build();

        Assertions.assertEquals(competition, game.competition());
    }

    @Test
    public void testBuild_withCompetition() {
        Competition competition = Competition.UNKNOWN;

        Game game = new GameBuilder()
                .withCompetition(competition)
                .build();

        Assertions.assertEquals(competition, game.competition());
    }

    @Test
    public void testBuild_withDay_Consumer() {
        int number = 1;
        Day day = new DayBuilder()
                .withNumber(number)
                .build();

        Game game = new GameBuilder()
                .withDay(builder -> builder.withNumber(day.number()))
                .build();

        Assertions.assertEquals(day, game.day());
    }

    @Test
    public void testBuild_withDay() {
        Day day = Day.SINGLE_DAY_GAME;

        Game game = new GameBuilder()
                .withDay(day)
                .build();

        Assertions.assertEquals(day, game.day());
    }

    @Test
    public void testBuild_withHalle_Consumer() {
        Halle halle = new HalleBuilder()
                .withId(UUID.randomUUID())
                .withName("Stade de France")
                .withAddress(builder -> builder.withStreet("Rue du Stade"))
                .build();

        Game game = new GameBuilder()
                .withHalle(builder -> builder.withId(halle.id()))
                .build();

        Assertions.assertEquals(halle, game.halle());
    }

    @Test
    public void testBuild_withHalle() {
        Halle halle = Halle.UNKNOWN;

        Game game = new GameBuilder()
                .withHalle(halle)
                .build();

        Assertions.assertEquals(halle, game.halle());
    }

    @Test
    public void testBuild_withReferees_Consumer() {
        Referees referees = new RefereesBuilder()
                .withDesignatedReferee1(builder -> builder.withName("Referee 1"))
                .withDesignatedReferee2(builder -> builder.withName("Referee 2"))
                .withOfficiatingReferee1(builder -> builder.withName("Referee 3"))
                .withOfficiatingReferee2(builder -> builder.withName("Referee 4"))
                .build();

        Game game = new GameBuilder()
                .withReferees(builder -> {
                    builder.withDesignatedReferee1(referees.designatedReferee1());
                    builder.withDesignatedReferee2(referees.designatedReferee2());
                    builder.withOfficiatingReferee1(referees.officiatingReferee1());
                    builder.withOfficiatingReferee2(referees.officiatingReferee2());
                })
                .build();

        Assertions.assertEquals(referees, game.referees());
    }

    @Test
    public void testBuild_withReferees() {
        Referees referees = Referees.UNKNOWN;

        Game game = new GameBuilder()
                .withReferees(referees)
                .build();

        Assertions.assertEquals(referees, game.referees());
    }

    @Test
    public void testBuild_withHomeTeam_Consumer() {
        Team homeTeam = new TeamBuilder()
                .withId(UUID.randomUUID())
                .withCategory(builder -> builder.withId(UUID.randomUUID()))
                .withGender(Gender.MALE)
                .withNumber(1)
                .withClub(builder -> builder.withCode("ABC").withName("Club A"))
                .withTeamsColor(builder -> builder.withShirtColor1(TeamColor.BLUE))
                .withCoach(builder -> builder.withId(UUID.randomUUID()).withName("Coach A"))
                .build();

        Game game = new GameBuilder()
                .withHomeTeam(builder -> builder.withId(homeTeam.id()))
                .build();

        Assertions.assertEquals(homeTeam, game.homeTeam());
    }

    @Test
    public void testBuild_withHomeTeam() {
        Team homeTeam = new TeamBuilder()
                .withId(UUID.randomUUID())
                .withCategory(new Category(UUID.randomUUID(), "U12"))
                .withGender(Gender.MALE)
                .withNumber(1)
                .withClub(new Club("ABC", "Club A"))
                .withTeamsColor(new TeamsColor(TeamColor.BLUE, TeamColor.WHITE, null, null))
                .withCoach(new Coach(UUID.randomUUID(), "Coach A", null))
                .build();

        Game game = new GameBuilder()
                .withHomeTeam(homeTeam)
                .build();

        Assertions.assertEquals(homeTeam, game.homeTeam());
    }

    @Test
    public void testBuild_withVisitingTeam_Consumer() {
        Team visitingTeam = new TeamBuilder()
                .withId(UUID.randomUUID())
                .withCategory(builder -> builder.withId(UUID.randomUUID()))
                .withGender(Gender.FEMALE)
                .withNumber(2)
                .withClub(builder -> builder.withCode("DEF").withName("Club B"))
                .withTeamsColor(builder -> builder.withShirtColor1(TeamColor.RED))
                .withCoach(builder -> builder.withId(UUID.randomUUID()).withName("Coach B"))
                .build();

        Game game = new GameBuilder()
                .withVisitingTeam(builder -> builder.withId(visitingTeam.id()))
                .build();

        Assertions.assertEquals(visitingTeam, game.visitingTeam());
    }

    @Test
    public void testBuild_withVisitingTeam() {
        Team visitingTeam = new TeamBuilder()
                .withId(UUID.randomUUID())
                .withCategory(new Category(UUID.randomUUID(), "U14"))
                .withGender(Gender.FEMALE)
                .withNumber(2)
                .withClub(new Club("DEF", "Club B"))
                .withTeamsColor(new TeamsColor(TeamColor.RED, TeamColor.WHITE, null, null))
                .withCoach(new Coach(UUID.randomUUID(), "Coach B", null))
                .build();

        Game game = new GameBuilder()
                .withVisitingTeam(visitingTeam)
                .build();

        Assertions.assertEquals(visitingTeam, game.visitingTeam());
    }

    @Test
    public void testBuild_withScore_Consumer() {
        Score score = new ScoreBuilder()
                .withHomeScore(3)
                .withVisitingScore(2)
                .build();

        Game game = new GameBuilder()
                .withScore(builder -> {
                    builder.withHomeScore(score.homeScore());
                    builder.withVisitingScore(score.visitingScore());
                })
                .build();

        Assertions.assertEquals(score, game.score());
    }

    @Test
    public void testBuild_withScore() {
        Score score = new ScoreBuilder()
                .withHomeScore(3)
                .withVisitingScore(2)
                .build();

        Game game = new GameBuilder()
                .withScore(score)
                .build();

        Assertions.assertEquals(score, game.score());
    }

    @Test
    public void testBuild_withFDME_Consumer() {
        FDME fdme = new FDMEBuilder()
                .withUrl(new URL("https://example.com/fdme"))
                .build();

        Game game = new GameBuilder()
                .withFDME(builder -> builder.withUrl(fdme.url()))
                .build();

        Assertions.assertEquals(fdme, game.fdme());
    }

    @Test
    public void testBuild_withFDME() {
        FDME fdme = new FDMEBuilder()
                .withUrl(new URL("https://example.com/fdme"))
                .build();

        Game game = new GameBuilder()
                .withFDME(fdme)
                .build();

        Assertions.assertEquals(fdme, game.fdme());
    }

    @Test
    public void testBuild_withDateTime() {
        LocalDateTime dateTime = LocalDateTime.of(2022, 10, 15, 14, 0);

        Game game = new GameBuilder()
                .withDateTime(dateTime)
                .build();

        Assertions.assertEquals(dateTime, game.dateTime());
    }

    @Test
    public void testBuild_complete() {
        String code = "G001";
        Competition competition = new Competition(UUID.randomUUID(), "Ligue des Champions", null);
        Day day = new Day(1);
        Halle halle = new Halle(UUID.randomUUID(), "Stade de France", null, null);
        Referees referees = new Referees(null, null, null, null);
        Team homeTeam = new Team(UUID.randomUUID(), new Category(UUID.randomUUID(), "U12"), Gender.MALE, 1,
                new Club("ABC", "Club A"), null, null);
        Team visitingTeam = new Team(UUID.randomUUID(), new Category(UUID.randomUUID(), "U14"), Gender.FEMALE, 2,
                new Club("DEF", "Club B"), null, null);
        Score score = new Score(3, 2);
        FDME fdme = new FDME(new DocFlavor.URL("https://example.com/fdme"));
        LocalDateTime dateTime = LocalDateTime.of(2022, 10, 15, 14, 0);

        Game game = new GameBuilder()
                .withCode(code)
                .withCompetition(competition)
                .withDay(day)
                .withHalle(halle)
                .withReferees(referees)
                .withHomeTeam(homeTeam)
                .withVisitingTeam(visitingTeam)
                .withScore(score)
                .withFDME(fdme)
                .withDateTime(dateTime)
                .build();

        Assertions.assertEquals(code, game.code());
        Assertions.assertEquals(competition, game.competition());
        Assertions.assertEquals(day, game.day());
        Assertions.assertEquals(halle, game.halle());
        Assertions.assertEquals(referees, game.referees());
        Assertions.assertEquals(homeTeam, game.homeTeam());
        Assertions.assertEquals(visitingTeam, game.visitingTeam());
        Assertions.assertEquals(score, game.score());
        Assertions.assertEquals(fdme, game.fdme());
        Assertions.assertEquals(dateTime, game.dateTime());
    }
}