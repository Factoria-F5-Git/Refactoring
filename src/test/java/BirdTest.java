import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BirdTest {

    @Test
    public void getSpeedShouldReturn9ForEuropeanBird(){
        Bird bird = new Bird(Origin.EUROPEAN, 0, 0, true);

        assertEquals(9.0, bird.getBaseSpeed());
    }

    //what other tests can we add?
}