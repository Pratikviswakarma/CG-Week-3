import SpecificWord.SpecificWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SpecificWordTest {
    @Test
    void test(){
        SpecificWord sw=new SpecificWord();
        String[] arr={"My name is pratik","My name is rajan","My name is neeraj bhai","My name is abhishek","My name is anju"};
        String wordToFind="pratik";
        Assertions.assertEquals("My name is pratik",sw.specificWord(arr,wordToFind));
    }
}
