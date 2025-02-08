import org.junit.jupiter.api.Test;
import recursivevsiterative.RecursiveVSIterative;

public class RecursiveVSIterativeTest {
    @Test
    void test(){
        RecursiveVSIterative rvi=new RecursiveVSIterative();
        rvi.fibonacciRecursive(40);
        rvi.fibonacciIterative(40);
    }
}
