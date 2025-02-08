import filereading.LargeFileReader;
import org.junit.jupiter.api.Test;

public class LargeFileReaderTest {
    @Test
    void test(){
        LargeFileReader lfr=new LargeFileReader();
        lfr.usingFileReader("D:\\A notes\\ForFileReaderExample.txt");
        lfr.usingInputStreamReader("D:\\A notes\\ForFileReaderExample.txt");
    }
}
