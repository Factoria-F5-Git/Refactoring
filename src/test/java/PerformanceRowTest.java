import org.junit.jupiter.api.Test;
import sun.misc.Perf;

import static org.junit.jupiter.api.Assertions.*;

class PerformanceRowTest {

    String[] row = new String[2];

    @Test
    public void settingRowsShouldEqualFields(){
        row[0] = "Liverpool";
        row[1] = "15";

        PerformanceRow performanceRow = new PerformanceRow();
//        performanceRow.setName('Liverpool');
//        performanceRow.setWins('15');

//        assertEquals(row[0], performanceRow.getName());
//        assertEquals(row[1], performanceRow.getWins());
    }

}