import largedataefficiently.LargeData;
import org.junit.jupiter.api.Test;

public class LargeDataTest {
    @Test
    void test(){
        LargeData ld=new LargeData();
        ld.bubbleSort(new int[]{50,40,30,20,10});
        ld.quickSort(new int[]{50,40,30,20,10},0,4);
        ld.mergeSort(new int[]{50,40,30,20,10},0,4);
    }
}
