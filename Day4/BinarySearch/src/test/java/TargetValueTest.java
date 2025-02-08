import TargetValue.TargetValue;
import org.junit.jupiter.api.Test;

public class TargetValueTest {
    @Test
    void test(){
        TargetValue tv=new TargetValue();
        tv.searchMatrix(new int[][] {{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 60}},3);
    }
}
