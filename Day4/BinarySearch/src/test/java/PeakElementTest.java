import PeakElement.PeakElement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PeakElementTest {
    @Test
    void test(){
        PeakElement pe=new PeakElement();
        int[] arr={1,3,20,4,1,0};
        int peekelement=pe.findPeakElement(arr);
        Assertions.assertEquals(20,arr[peekelement]);
    }
}
