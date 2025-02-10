import comparindsforsearching.ComparisionDSSearching;
import org.junit.jupiter.api.Test;

public class ComparisionDSSearchingTest {
    @Test
    void test(){
        ComparisionDSSearching cdss=new ComparisionDSSearching();
        cdss.linearSearch(new int[]{50,45,12,451,24,514,78,2,4,55,6,789,4,51,2,450,455,24,61,3,54,789,55,741,66,75,185,812},185);
        cdss.hashSet(new int[]{50,45,12,451,24,514,78,2,4,55,6,789,4,51,2,450,455,24,61,3,54,789,55,741,66,75,185,812},185);
        cdss.treeSet(new int[]{50,45,12,451,24,514,78,2,4,55,6,789,4,51,2,450,455,24,61,3,54,789,55,741,66,75,185,812},185);
    }
}
