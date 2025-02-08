import WriteInFile.WriteInFile;
import org.junit.jupiter.api.Test;

public class WriteInFileTest {
    @Test
    void test(){
        WriteInFile wif=new WriteInFile();
        String filePath="D:\\A notes\\FileWriting.txt";
        wif.printWithFile(filePath);
    }
}
