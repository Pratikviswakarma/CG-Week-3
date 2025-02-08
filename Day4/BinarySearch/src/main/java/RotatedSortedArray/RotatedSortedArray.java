package RotatedSortedArray;

public class RotatedSortedArray {
    // Creating method to point calculation
    public static int pointCalculate(int arr[]){
        int left = 0;
        int right = arr.length - 1;

        while(left < right){
            int mid = (left+right)/2;
            if(arr[mid] > arr[right]){
                left = mid +1;
            }else{
                right = mid;
            }
        }
        return left;
    }
    public static void main(String[] args) {
        // Created array
        int arr[] = {6,7,9,15,20,2,3};
        // receiving method result in a variable
        int rotationPoint =pointCalculate(arr);
        // Display the outputs
        System.out.println("The index of the smallest element :"+rotationPoint);

    }

}
