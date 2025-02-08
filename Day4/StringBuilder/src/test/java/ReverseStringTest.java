import ReverseString.ReverseString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseStringTest {
    @Test
    void revStr(){
        ReverseString rs=new ReverseString();
        assertEquals("olleh",rs.reverseString("hello"));
    }

}
