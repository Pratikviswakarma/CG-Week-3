package FIrstAndLastOccurrence;

public class FirstAndLastOccurrence {
    // Calculating first  index occurence
    public static int firstOccurenceIndex(int arr[],int target,int left,int right){
        if(left > right){
            return -1;
        }
        else{
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return firstOccurenceIndex(arr,target,left,mid -1);
            }else{
                return firstOccurenceIndex(arr,target,mid +1,right);
            }
        }
    }
    // Method to find last occurence
    public static int lastOccurenceIndex(int arr[], int target,int left,int right){
        // Reversing the array to find last index of occurence
        int n = arr.length;
        for(int i=0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        // applying binary search
        if(left > right){
            return -1;
        }
        else{
            int mid = (left + right)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                return lastOccurenceIndex(arr, target,left,mid -1);
            }else{
                return lastOccurenceIndex(arr, target,mid +1,right);
            }
        }

    }
    public static void main(String[] args) {
        // Creating  array
        int arr[] = {1,2,3,5,6};
        int target = 3;
        int left = 0;
        int right = arr.length -1;
        // Display the result
        System.out.println("The First Occurence index is "+firstOccurenceIndex(arr,target,left,right));
        System.out.println("The Last Occurence index is "+lastOccurenceIndex(arr,target,left,right));

    }
}
