import CountOccurrenceOfWord.CountOccurrenceOfWord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountOccurrenceOfWordTest {
    @Test
    void test(){
        CountOccurrenceOfWord cow=new CountOccurrenceOfWord();
        String wordToFind="input";
        Assertions.assertEquals(3,cow.countWordOccurrence("D:\\A notes\\ForFileReaderExample.txt",wordToFind));
    }
}
