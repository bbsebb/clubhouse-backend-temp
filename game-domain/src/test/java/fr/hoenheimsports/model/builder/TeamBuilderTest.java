package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class TeamBuilderTest {

    @Test
    public void testBuild() {
        UUID id = UUID.randomUUID();
        Category category = new Category(UUID.randomUUID(), "Category A");
        Gender gender = Gender.MALE;
        int number = 1;
        Club club = new Club("Club A", "ABC");
        TeamsColor teamsColor = new TeamsColor(
                TeamColor.BLUE,
                TeamColor.WHITE,
                TeamColor.RED,
                TeamColor.YELLOW
        );
        Coach coach = new Coach(UUID.randomUUID(), "Coach A", new PhoneNumber("555555555"));

        Team team = new TeamBuilder()
                .withId(id)
                .withCategory(builder -> builder
                        .withId(category.id())
                        .withName(category.name())
                )
                .withGender(gender)
                .withNumber(number)
                .withClub(builder -> builder
                        .withName(club.name())
                        .withCode(club.code())
                )
                .withTeamsColor(builder -> builder
                        .withShirtColor1(colorBuilder -> colorBuilder.withFrenchName(teamsColor.shirtColor1().getFrenchName()))
                        .withShirtColor2(colorBuilder -> colorBuilder.withFrenchName(teamsColor.shirtColor2().getFrenchName()))
                        .withGoalkeeperColor1(colorBuilder -> colorBuilder.withFrenchName(teamsColor.goalkeeperColor1().getFrenchName()))
                        .withGoalkeeperColor2(colorBuilder -> colorBuilder.withFrenchName(teamsColor.goalkeeperColor2().getFrenchName()))
                )
                .withCoach(builder -> builder
                        .withId(coach.id())
                        .withName(coach.name())
                        .withPhoneNumber(coach.phoneNumber())
                )
                .build();

        assertEquals(id, team.id());
        assertEquals(category, team.category());
        assertEquals(gender, team.gender());
        assertEquals(number, team.number());
        assertEquals(club, team.club());
        assertEquals(teamsColor, team.teamsColor());
        assertEquals(coach, team.coach());
    }

    @Test
    public void testBuildWithObject() {
        UUID id = UUID.randomUUID();
        Category category = new Category(UUID.randomUUID(), "Category A");
        Gender gender = Gender.MALE;
        int number = 1;
        Club club = new Club("Club A", "ABC");
        TeamsColor teamsColor = new TeamsColor(
                TeamColor.BLUE,
                TeamColor.WHITE,
                TeamColor.RED,
                TeamColor.YELLOW
        );
        Coach coach = new Coach(UUID.randomUUID(), "Coach A", new PhoneNumber("555555555"));

        Team team = new TeamBuilder()
                .withId(id)
                .withCategory(category)
                .withGender(gender)
                .withNumber(number)
                .withClub(club)
                .withTeamsColor(teamsColor)
                .withCoach(coach)
                .build();

        assertEquals(id, team.id());
        assertEquals(category, team.category());
        assertEquals(gender, team.gender());
        assertEquals(number, team.number());
        assertEquals(club, team.club());
        assertEquals(teamsColor, team.teamsColor());
        assertEquals(coach, team.coach());
    }
}