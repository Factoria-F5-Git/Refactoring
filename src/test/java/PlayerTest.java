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
    public void shouldHave2PointsIfPlayerHasTheBall() {
        assertEquals(0, player.getTotalPoints());

        player.shoot();
        assertEquals(2, player.getTotalPoints());
    }

    @Test
    public void shouldNotDoHaveAnyPointIfPlayerDoesNotHaveTheBall() {
        player.ballPossession = 0;
        assertEquals(0, player.getTotalPoints());
    }

    @Test
    public void shouldMakeOtherPlayerScoreIfPlayerHasTheBall() {
        Player otherPlayer = new Player(0, 2, Player.NOT_IN_POSSESSION_OF_THE_BALL);
        player.pass(otherPlayer);

        assertEquals(2, otherPlayer.getTotalPoints());
        assertTrue(player.ballPossession == Player.NOT_IN_POSSESSION_OF_THE_BALL);
        assertTrue(otherPlayer.ballPossession == Player.IN_POSSESSION_OF_THE_BALL);
    }

    @Test
    public void shouldNotMakeOtherPlayerScoreIfPlayerDoesNotHaveTheBall() {
        Player otherPlayer = new Player(0, 2, Player.NOT_IN_POSSESSION_OF_THE_BALL);
        player.ballPossession = Player.NOT_IN_POSSESSION_OF_THE_BALL;
        player.pass(otherPlayer);

        assertEquals(0, player.getTotalPoints());
    }
}
