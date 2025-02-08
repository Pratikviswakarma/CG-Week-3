package stringconcateperformance;

public class StringConcatenation {
    public static void usingString(String str){
        long start=System.nanoTime();
        String s="";
        for(int i=0;i<10000;i++){
            s+=str;
        }
        long end=System.nanoTime();
        System.out.println("Time taken by String "+(end-start));
    }
    public static void usingStringBuilder(String str){
        long start=System.nanoTime();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10000;i++){
            sb.append(str);
        }
        long end=System.nanoTime();
        System.out.println("Time taken by StringBuilder "+(end-start));
    }
    public static void usingStringBuffer(String str){
        long start=System.nanoTime();
        StringBuffer sbf=new StringBuffer();
        for(int i=0;i<10000;i++){
            sbf.append(str);
        }
        long end=System.nanoTime();
        System.out.println("Time taken by StringBuffer "+(end-start));
    }
    public static void main(String[] args) {
        String s="Hello";
        usingString(s);
        usingStringBuilder(s);
        usingStringBuffer(s);
    }
}
