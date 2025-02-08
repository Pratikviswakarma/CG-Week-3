package ReadLineByLine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLineByLine {
    //Method to read line by line
    public static void readLineByLine(String filePath){
        try{
            FileReader file=new FileReader(filePath);
            BufferedReader br=new BufferedReader(file);
            String line="";
            while((line=br.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException ex){
            System.out.println("Error during "+ex.getMessage());
        }
    }
    public static void main(String[] args) {
            //Path of file in local Storage
            String filePath="D:\\A notes\\ForFileReaderExample.txt";
            readLineByLine(filePath);

    }
}
