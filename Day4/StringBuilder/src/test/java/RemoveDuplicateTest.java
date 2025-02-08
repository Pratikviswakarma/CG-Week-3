import RemoveDuplicates.RemoveDuplicate;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RemoveDuplicateTest {

    @Test
    void remDup(){
        RemoveDuplicate rd=new RemoveDuplicate();
        assertEquals("helo",rd.removeDuplicate("hello"));
    }
}
