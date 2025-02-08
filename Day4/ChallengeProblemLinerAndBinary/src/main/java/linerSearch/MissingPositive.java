package linerSearch;

import java.util.Arrays;

public class MissingPositive {
    //Method for finding missing positive integer
    public static int missingPositive(int[] arr){
       for(int i=0;i< arr.length;i++){
           if(arr[i]>=0){
               //if condition fulfilled then return that index
               return i;
           }
       }
        return -1;
    }


    public static void main(String[] args) {
        //Array of negative and positive
        int[] arr={-1,-24,-5,7,-89};
        System.out.println("First missing Positive Integer is "+missingPositive(arr));
    }
}
