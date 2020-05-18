import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CitizenTest {

    @Test
    public void getPayAmountShouldReturn5ForGeneralCase(){
        Citizen citizen = new Citizen(false, false, false);

        assertEquals(5, citizen.getPayAmount(), 0.1);
    }

    @Test
    public void disabilityAmountShouldReturn0IfTheCitizenIsPartTime(){
        Citizen citizen = new Citizen(0, 0, true);

        assertEquals(0, citizen.disabilityAmount(), 0.1);
    }

}