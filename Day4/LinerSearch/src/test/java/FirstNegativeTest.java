import FirstNegative.FirstNegative;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FirstNegativeTest {
    @Test
    void test(){
        FirstNegative fn=new FirstNegative();
        int[] arr={10,20,-4,15,85,74,22,45};
        Assertions.assertEquals(2,fn.firstNegative(arr));

    }
}
