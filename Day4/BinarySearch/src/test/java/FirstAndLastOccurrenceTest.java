import FIrstAndLastOccurrence.FirstAndLastOccurrence;
import org.junit.jupiter.api.Test;

public class FirstAndLastOccurrenceTest {
    @Test
    void test(){
        FirstAndLastOccurrence flc=new FirstAndLastOccurrence();
        flc.firstOccurenceIndex(new int[]{1,2,3,5,6},3,0,5);
        flc.lastOccurenceIndex(new int[]{1,2,3,5,6},2,0,5);
    }
}
