import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

class ChargeTest {

    @Test
    public void calculateChargeShouldReturnDoubleWhenIsSummerRate(){
        Date summerDate = new GregorianCalendar(2020, Calendar.JULY, 20).getTime();

        Charge charge = new Charge(12);
        assertEquals(24, charge.calculateCharge(summerDate));
    }

}