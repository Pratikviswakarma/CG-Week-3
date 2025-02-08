import ByteStreamToCharacterStream.ByteStreamToCharacterStream;
import org.junit.jupiter.api.Test;

public class ByteStreamToCharacterStreamTest {
    @Test
    void test(){
        ByteStreamToCharacterStream bscs=new ByteStreamToCharacterStream();
        bscs.bytetochracter("D:\\A notes\\ForFileReaderExample.txt");
    }
}
