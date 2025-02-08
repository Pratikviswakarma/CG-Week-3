package ByteStreamToCharacterStream;

import java.io.*;


public class ByteStreamToCharacterStream {
    //Method to convert Byte to Character
    public static void bytetochracter(String filePath){
       try{
           FileInputStream fis=new FileInputStream(filePath);
           InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
           BufferedReader br=new BufferedReader(isr);
           String line="";

           while ((line=br.readLine())!=null){
               System.out.println(line);
           }

       }catch (IOException ex){
           System.out.println("Exception due to "+ex.getMessage());
       }
    }
    public static void main(String[] args) {
      //Path in local Storage
      String filePath="D:\\A notes\\ForFileReaderExample.txt";
      bytetochracter(filePath);
    }
}
