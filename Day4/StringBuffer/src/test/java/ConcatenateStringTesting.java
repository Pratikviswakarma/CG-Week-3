import ConcatenateString.ConcatenateString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConcatenateStringTesting {
    @Test
    void concate(){
        ConcatenateString cs=new ConcatenateString();
        String[] arr={"My","name","is","pratik","vishwakarma"};
        assertEquals("Mynameispratikvishwakarma",cs.concatenate(arr));
    }
}
