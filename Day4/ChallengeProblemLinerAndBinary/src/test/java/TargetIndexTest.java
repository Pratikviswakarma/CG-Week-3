import BinarySearch.TargetIndex;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TargetIndexTest {
    @Test
    void test(){
        TargetIndex ti=new TargetIndex();
        // Array for find target's value
        int[] arr={10,20,40,50,46,12};
        //target value to find
        int target=50;
        Assertions.assertEquals(3,ti.targetIndex(arr,target));
    }
}
