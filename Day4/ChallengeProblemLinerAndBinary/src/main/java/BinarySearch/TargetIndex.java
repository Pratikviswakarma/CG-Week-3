package BinarySearch;

public class TargetIndex {
  //Method to find target Index
    public static int targetIndex(int[] arr,int target){
        int low=0;
        int high= arr.length-1,mid=0;
        while (low<=high){
            //calculating mid element
            mid=low+(high-low)/2;
            //check mid element is target element or not
            if(arr[mid]==target){
                return mid;
            }
            else if(arr[mid]>target){
                high=mid+1;
            }else{
                low=mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        // Array for find target's value
        int[] arr={10,20,40,50,46,12};
        //target value to find
        int target=50;
        System.out.println("Target Element at index "+targetIndex(arr,target));
    }
}
