import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

class CitizenTest {

    Citizen citizen;

    @BeforeEach
    public void before(){
        citizen = new Citizen();
    }

    @Test
    public void getPayAmountShouldReturn5ForGeneralCase(){
        citizen.isSeparated = false;
        citizen.isDead = false;
        citizen.isRetired = false;
        assertEquals(5, citizen.getPayAmount(), 0.1);
    }

    @Test
    public void disabilityAmountShouldReturn0IfTheCitizenIsPartTime(){
        citizen.monthsDisabled = 0;
        citizen.seniority = 0;
        citizen.isPartTime = true;

        assertEquals(0, citizen.disabilityAmount(), 0.1);
    }

}