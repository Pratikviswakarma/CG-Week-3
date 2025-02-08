import FileReaderAndInputStreamReader.FileReaderAndInputStreamReader;
import org.junit.jupiter.api.Test;

public class FileReaderAndInputStreamReaderTest {
    @Test
   void test(){
        FileReaderAndInputStreamReader frisr=new FileReaderAndInputStreamReader();
        String filePath="D:\\A notes\\comareIsrAndfr.txt";
        frisr.compareFrAndIsr(filePath);
    }
}
