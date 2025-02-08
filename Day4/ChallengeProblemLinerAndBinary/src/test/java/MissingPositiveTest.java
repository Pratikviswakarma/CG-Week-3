import linerSearch.MissingPositive;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MissingPositiveTest {
    @Test
    void test(){
        MissingPositive ms=new MissingPositive();
        int[] arr={-1,-24,-5,7,-89};
        Assertions.assertEquals(3,ms.missingPositive(arr));
    }
}

