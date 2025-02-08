package filereading;

import java.io.*;

public class LargeFileReader {
    public static void usingFileReader(String filePath){
        long start=System.nanoTime();
        try{
            FileReader fr=new FileReader(filePath);
            BufferedReader br=new BufferedReader(fr);
            String line="";
            while((line= br.readLine())!=null){
                System.out.print("");
            }
        }catch (IOException ex){
            System.out.println("Exception due to "+ex.getMessage());
        }
        long end=System.nanoTime();
        System.out.println("Time taken by File Reader "+(end-start));
    }

    public static void usingInputStreamReader(String filePath){
        long start=System.nanoTime();
        try{
            FileInputStream fis=new FileInputStream(filePath);
            InputStreamReader isr=new InputStreamReader(fis);
            BufferedReader br=new BufferedReader(isr);
            String line="";
            while((line= br.readLine())!=null){
                System.out.print("");
            }
        }catch (IOException ex){
            System.out.println("Exception due to "+ex.getMessage());
        }
        long end=System.nanoTime();
        System.out.println("Time taken by Input Stream Reader "+(end-start));
    }

    public static void main(String[] args) {
        String filePath="D:\\A notes\\ForFileReaderExample.txt";
        usingFileReader(filePath);
        usingInputStreamReader(filePath);
    }
}
