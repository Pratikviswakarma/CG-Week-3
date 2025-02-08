package FirstNegative;

public class FirstNegative {
    //Method to find first Negative
    public  static int firstNegative(int[] arr){
        int index=-1;
        for(int i=0;i< arr.length;i++){
            if(arr[i]<0){
                index=i;
                return index;
            }
        }
        return index;
    }
    public static void main(String[] args) {
        //Array to find first negative element
        int[] arr={10,20,-4,15,85,74,22,45};
        System.out.println(firstNegative(arr));
    }
}
