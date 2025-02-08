package FileReaderAndInputStreamReader;

import java.io.*;
import java.nio.charset.StandardCharsets;



public class FileReaderAndInputStreamReader {
    //Method for comapre FileReader and InputStreamReader
    public static void compareFrAndIsr(String filePath){
        try{
            //Count words with fileReader and checks how much time is taken by it
            FileReader fr=new FileReader(filePath);
            BufferedReader br=new BufferedReader(fr);
            long before=System.nanoTime();
            int wordCount=0;
            String line="";
            while((br.readLine())!=null){
                wordCount+=line.split(" ").length;
            }
            long after=System.nanoTime();
            System.out.println("Time taken by file Reader "+(after-before)+" Words are "+wordCount);

            //Count words with InputStreamReader and checks how much time is taken by it
            FileInputStream fis=new FileInputStream(filePath);
            InputStreamReader isr=new InputStreamReader(fis, StandardCharsets.UTF_8);
            br=new BufferedReader(isr);
            before=System.nanoTime();
            wordCount=0;
            line="";
            while((br.readLine())!=null){
                wordCount+=line.split(" ").length;
            }
            after=System.nanoTime();
            System.out.println("Time taken by fileInputStreamReader "+(after-before)+" Words are "+wordCount);

        }catch (IOException ex){
            System.out.println("Error due to "+ex.getMessage());
        }
    }
    public static void main(String[] args) {
        //file path in local system
        String filePath="D:\\A notes\\comareIsrAndfr.txt";
        //call method for compare FileReader and InputStreamReader
        compareFrAndIsr(filePath);
    }
}
