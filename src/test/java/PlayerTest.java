import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
    private Player player;

    @BeforeEach
    public void beforeEach() {
        player = new Player(0, 2, Player.IN_POSSESSION_OF_THE_BALL);
    }

    @Test
    public void shootShouldAdd2TotalPointsIfPlayerHasTheBall() {
        assertEquals(0, player.totalPoints);

        player.shoot();
        assertEquals(2, player.totalPoints);
    }

    @Test
    public void shootShouldNotAddAnyPointIfPlayerDoesNotHaveTheBall() {
        player.ballPossession = 0;

        player.shoot();
        assertEquals(0, player.totalPoints);
    }

    @Test
    public void passShouldMakeOtherPlayerScoreIfInitialPlayerHasTheBall() {
        Player otherPlayer = new Player(0, 2, Player.NOT_IN_POSSESSION_OF_THE_BALL);
        player.pass(otherPlayer);

        assertEquals(2, otherPlayer.totalPoints);
        assertTrue(player.ballPossession == Player.NOT_IN_POSSESSION_OF_THE_BALL);
        assertTrue(otherPlayer.ballPossession == Player.IN_POSSESSION_OF_THE_BALL);
    }

    @Test
    public void shouldNotMakeOtherPlayerScoreIfInitialPlayerDoesNotHaveTheBall() {
        Player otherPlayer = new Player(0, 2, Player.NOT_IN_POSSESSION_OF_THE_BALL);
        player.ballPossession = Player.NOT_IN_POSSESSION_OF_THE_BALL;
        player.pass(otherPlayer);

        assertEquals(0, player.totalPoints);
    }
}
