package CountOccurrenceOfWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CountOccurrenceOfWord {
    //Method for count occurrence of word
    public static int countWordOccurrence(String filePath,String wordToFind){
        int count=0;
        try{
            FileReader fr=new FileReader(filePath);
            BufferedReader br=new BufferedReader(fr);
            String line="";
            while ((line=br.readLine())!=null) {
                String[] temp = line.split(" ");
                for(int i = 0; i < temp.length; i++) {
                    if (temp[i].equals(wordToFind)) {
                        count++;
                    }
                }
            }
        }catch (IOException ex){
            System.out.println("Exception due to "+ex.getMessage());
        }
        return count;
    }


    public static void main(String[] args) {
        //Path of file in local Storage
        String filePath="D:\\A notes\\ForFileReaderExample.txt";
       //Word to find in file
        String wordToFind="input";
        System.out.println(countWordOccurrence(filePath,wordToFind));
    }
}
