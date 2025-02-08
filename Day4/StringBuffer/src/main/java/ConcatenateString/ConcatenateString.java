package ConcatenateString;


public class ConcatenateString {
    //Method to perform concatenation Operation of array
    public static String concatenate(String[] arr){
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        //Array for converting in a single String
        String[] arr={"My","name","is","pratik","vishwakarma"};
        System.out.println(concatenate(arr));

    }
}
