package fr.hoenheimsports.model.builder;

import fr.hoenheimsports.model.Referee;
import fr.hoenheimsports.model.Referees;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RefereesBuilderTest {

    @Test
    public void testRefereesBuilder() {
        RefereesBuilder refereesBuilder = new RefereesBuilder();
        String expectedReferee1Name = "John Doe";
        String expectedReferee2Name = "Jane Smith";
        String expectedReferee3Name = "Mike Johnson";
        String expectedReferee4Name = "Sarah Brown";

        Referees referees = refereesBuilder
                .withDesignatedReferee1(refereeBuilder -> refereeBuilder.withName(expectedReferee1Name))
                .withDesignatedReferee2(refereeBuilder -> refereeBuilder.withName(expectedReferee2Name))
                .withOfficiatingReferee1(refereeBuilder -> refereeBuilder.withName(expectedReferee3Name))
                .withOfficiatingReferee2(refereeBuilder -> refereeBuilder.withName(expectedReferee4Name))
                .build();

        assertNotNull(referees.designatedReferee1());
        assertEquals(expectedReferee1Name, referees.designatedReferee1().name());

        assertNotNull(referees.designatedReferee2());
        assertEquals(expectedReferee2Name, referees.designatedReferee2().name());

        assertNotNull(referees.officiatingReferee1());
        assertEquals(expectedReferee3Name, referees.officiatingReferee1().name());

        assertNotNull(referees.officiatingReferee2());
        assertEquals(expectedReferee4Name, referees.officiatingReferee2().name());
    }

    @Test
    public void testRefereesBuilderWithRefereeObjects() {
        RefereesBuilder refereesBuilder = new RefereesBuilder();
        Referee expectedReferee1 = Referee.UNKNOWN;
        Referee expectedReferee2 = Referee.UNKNOWN;
        Referee expectedReferee3 = Referee.UNKNOWN;
        Referee expectedReferee4 = Referee.UNKNOWN;

        Referees referees = refereesBuilder
                .withDesignatedReferee1(expectedReferee1)
                .withDesignatedReferee2(expectedReferee2)
                .withOfficiatingReferee1(expectedReferee3)
                .withOfficiatingReferee2(expectedReferee4)
                .build();

        assertEquals(expectedReferee1, referees.designatedReferee1());
        assertEquals(expectedReferee2, referees.designatedReferee2());
        assertEquals(expectedReferee3, referees.officiatingReferee1());
        assertEquals(expectedReferee4, referees.officiatingReferee2());
    }
}