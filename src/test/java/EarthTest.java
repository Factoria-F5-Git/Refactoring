import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class EarthTest {

  @Test
  public void calculatesPotentialEnergyCorrectly() {
      Earth earth = new Earth();
      assertEquals(9810, earth.potentialEnergy(10, 100));
      assertEquals(0, earth.potentialEnergy(10, 0));
  }
}
