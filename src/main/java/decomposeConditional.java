import java.util.*;

class Charge {

    public final Date SUMMER_END = new GregorianCalendar(2020, Calendar.SEPTEMBER, 20).getTime();
    public final Date SUMMER_START = new GregorianCalendar(2020, Calendar.JUNE, 20).getTime();
    public final int winterRate = 1;
    public final int summerRate = 2;

    public int quantity;

    Charge(int quantity){
        this.quantity = quantity;
    }

    public int calculateCharge(Date date) {
        int charge;
        if (date.before(SUMMER_START) || date.after(SUMMER_END)) {
            charge = quantity * winterRate;
        }
        else {
            charge = quantity * summerRate;
        }
        return charge;
    }

}
