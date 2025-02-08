package SpecificWord;

public class SpecificWord {
    //Method to fin Specific word in given string
    public static String specificWord(String[] str,String wordToFind){
        for(int i=0;i<str.length;i++){
            String[] temp=str[i].split(" ");
            for(int j=0;j<temp.length;j++){
                if(temp[j].equals(wordToFind)){
                    return str[i];
                }
            }
        }
        return "Not Found";
    }
    public static void main(String[] args) {
        //Array to find word
        String[] arr={"My name is pratik","My name is rajan","My name is neeraj bhai","My name is abhishek","My name is anju"};
        //word to find in array
        String wordToFind="pratik";
        System.out.println(specificWord(arr,wordToFind));
    }
}
