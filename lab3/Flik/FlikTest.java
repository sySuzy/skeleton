import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {

    @Test
    public void testIsSameNumber() {
        assertTrue(Flik.isSameNumber(1,1));
        assertTrue(!Flik.isSameNumber(1,2));
    }

}