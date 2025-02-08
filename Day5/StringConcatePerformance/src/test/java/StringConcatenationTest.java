import org.junit.jupiter.api.Test;
import stringconcateperformance.StringConcatenation;

public class StringConcatenationTest {
    @Test
    void test(){
        StringConcatenation sc=new StringConcatenation();
        sc.usingString("Hello");
        sc.usingStringBuilder("Hello");
        sc.usingStringBuffer("Hello");
    }
}
