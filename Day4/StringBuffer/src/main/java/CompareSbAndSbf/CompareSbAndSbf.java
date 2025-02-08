package CompareSbAndSbf;

public class CompareSbAndSbf {
    //Method to check performance
    public static void compareWithTime(String str){
        StringBuilder sb=new StringBuilder();
        StringBuffer sbf=new StringBuffer();
        long sbtimebefor=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append(str);
        }
        //Time taken by StringBuilder
        long sbtimeafter=System.nanoTime();
        System.out.println("Total time taken by StringBuilder "+(sbtimeafter-sbtimebefor)+" ns");

        long sbftimebefor=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sbf.append(str);
        }
        //Time taken by StringBuffer
        long sbftimeafter=System.nanoTime();
        System.out.println("Total time taken by StringBuffer "+(sbftimeafter-sbftimebefor)+" ns");

    }
    public static void main(String[] args) {
        //Demo String for checking performance of StringBuilder and StringBuffer
        String str="hello";
        compareWithTime(str);
    }
}
