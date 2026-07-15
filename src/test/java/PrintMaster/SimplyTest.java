package PrintMaster;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class SimplyTest {

    @Test
    public void testAdd(){
        App app = new App();
        int result = app.add(2, 3);
        assertEquals(5, result);
    }


}
