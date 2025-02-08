package RemoveDuplicates;

import java.util.HashSet;

public class RemoveDuplicate {
    //Method to remove duplicates form string
    public static String removeDuplicate(String str){
        StringBuilder sb=new StringBuilder();
        HashSet<Character> hs=new HashSet<>();
        //Traverse through String And add only unique character
        for(int i=0;i<str.length();i++){
            if(!hs.contains(str.charAt(i))){
                hs.add(str.charAt(i));
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //String to remove duplicate
        String str="hello";
        System.out.println(removeDuplicate(str));
    }
}
