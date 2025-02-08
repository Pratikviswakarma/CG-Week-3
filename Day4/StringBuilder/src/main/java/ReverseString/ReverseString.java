package ReverseString;

public class ReverseString {
    //Method to revere String
    public static String reverseString(String str){
        StringBuilder sb=new StringBuilder();
        sb.append(str);
        sb=sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        //String to reverse it
        String str="hello";
        System.out.println(reverseString(str));
    }
}
