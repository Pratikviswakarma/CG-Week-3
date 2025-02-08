package PeakElement;

public class PeakElement {
    // Creating Method to find peak element and return it
    public static int findPeakElement(int arr[]){
        // Declare left and right
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;

            }
            if (mid > 0 && arr[mid - 1] > arr[mid]) {
                right = mid - 1;
            }

            else {
                left = mid + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        // Creating array
        int arr[] = {1,3,20,4,1,0};

        // Method calling
        int peakIndex = findPeakElement(arr);

        // Display result
        System.out.println("The peak element is: " + arr[peakIndex]);
    }

}
