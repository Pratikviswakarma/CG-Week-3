package largedataefficiently;

import java.util.Arrays;

public class LargeData {
    // Performing bubble Sort
    public static void bubbleSort(int[] arr){

        for(int i=0;i<arr.length-1;i++){
            boolean flag=false;
            for(int j=0;j< arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                    flag=true;
                }
            }
            if(!flag){
                break;
            }
        }
    }

    // Performing quick Sort
    public static void quickSort(int[] arr,int low,int high){
        if(low<high){
            int pivot=partition(arr,low,high);
            quickSort(arr,low,pivot-1);
            quickSort(arr,pivot+1,high);
        }
    }
    private static int partition(int[] arr,int low,int high){
        int pi=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pi){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=temp;

        return i+1;
    }
    //Performing Merge sort
        private static void merge(int[] arr, int left, int mid, int right) {
            int n1 = mid - left + 1;
            int n2 = right - mid;

            int[] leftArray = new int[n1];
            int[] rightArray = new int[n2];

            System.arraycopy(arr, left, leftArray, 0, n1);
            System.arraycopy(arr, mid + 1, rightArray, 0, n2);

            int i = 0, j = 0, k = left;

            while (i < n1 && j < n2) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k] = leftArray[i];
                    i++;
                } else {
                    arr[k] = rightArray[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                arr[k] = leftArray[i];
                i++;
                k++;
            }

            while (j < n2) {
                arr[k] = rightArray[j];
                j++;
                k++;
            }
        }

        public static void mergeSort(int[] arr, int left, int right) {
            if (left < right) {
                int mid = left + (right - left) / 2;

                mergeSort(arr, left, mid);
                mergeSort(arr, mid + 1, right);

                merge(arr, left, mid, right);
            }
        }

    // Main method
    public static void main(String[] args) {
        int[] arr={50,40,30,20,10};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        int[] brr={50,40,30,20,10};
        quickSort(brr,0, brr.length-1);
        System.out.println(Arrays.toString(brr));
        int[] crr={50,40,30,20,10};
        mergeSort(crr,0,crr.length-1);
        System.out.println(Arrays.toString(crr));
    }
}
