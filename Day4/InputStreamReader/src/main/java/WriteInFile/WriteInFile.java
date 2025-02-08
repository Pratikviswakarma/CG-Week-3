package WriteInFile;

import java.io.*;

public class WriteInFile {
    //Method to write in a file
    public static  void writeInFile(String filePath){
        try {
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader br=new BufferedReader(isr);
            FileWriter fw=new FileWriter(filePath);
            while (true){
                System.out.println("Enter text to write a file and enter exit to stop");
                String text=br.readLine();
                if(text.equalsIgnoreCase("exit")){
                    break;
                }
                fw.write(text);
            }
            isr.close();
            br.close();
            fw.close();
        }catch (IOException ex){
            System.out.println("Exception due to "+ex.getMessage());
        }
    }
    //Method to print in a file
    public static void printWithFile(String filePath){
       try{
           FileReader fr=new FileReader(filePath);
           BufferedReader br=new BufferedReader(fr);
           String line="";
            while ((line=br.readLine())!=null) {
                System.out.println(line);
            }
       }catch (IOException ex){
           System.out.println("Error due to "+ex.getMessage());
       }
    }
    public static void main(String[] args) {
        //File to path in local storage
        String filePath="D:\\A notes\\FileWriting.txt";
        //call to write in file
        writeInFile(filePath);
        //call to print in file
        printWithFile(filePath);
    }
}
