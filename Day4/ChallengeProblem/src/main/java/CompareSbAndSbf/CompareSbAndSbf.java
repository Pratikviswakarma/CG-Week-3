package CompareSbAndSbf;

public class CompareSbAndSbf {
    //Method for check performance of StringBuilder and StringBuffer
    public static void compareWithTime(String str){
        StringBuilder sb=new StringBuilder();
        StringBuffer sbf=new StringBuffer();
        long sbtimebefor=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sb.append(str);
        }
        long sbtimeafter=System.nanoTime();
        //Time taken by StringBuilder
        System.out.println("Total time taken by StringBuilder "+(sbtimeafter-sbtimebefor)+" ns");

        long sbftimebefor=System.nanoTime();
        for(int i=0;i<1000000;i++){
            sbf.append(str);
        }

        long sbftimeafter=System.nanoTime();
        //Time taken by StringBuffer
        System.out.println("Total time taken by StringBuffer "+(sbftimeafter-sbftimebefor)+" ns");

    }
    public static void main(String[] args) {
        //Demo string for check performance
        String str="hello";
        compareWithTime(str);
    }
}
