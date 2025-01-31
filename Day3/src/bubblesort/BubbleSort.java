package bubblesort;

import java.util.Arrays;

public class BubbleSort {
    // Method for sorting array element with bubble sort
    public static void bubblesort(int arr[]){
        boolean swap=false;
        int n=arr.length;
        for(int i=0;i< n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    swap=true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
    public static void main(String[] args) {
        //Students Number for sorting
        int studentMarks[]=new int[]{75,87,97,45,88,43,47,58,56,75};
        // Method call for sorting student marks
        bubblesort(studentMarks);
        // print sorted marks
        System.out.println(Arrays.toString(studentMarks));
    }
}
