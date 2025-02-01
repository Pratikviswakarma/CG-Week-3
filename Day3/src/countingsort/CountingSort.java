package countingsort;

import java.util.Arrays;

public class CountingSort {
    // Method for sorting array elements using Counting Sort
    public static void countingSort(int arr[], int max) {
        int count[] = new int[max + 1];
        int output[] = new int[arr.length];

        // Count occurrences of each element
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        // Compute cumulative count
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Place elements in sorted order
        for (int i = arr.length - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Copy sorted elements back to original array
        System.arraycopy(output, 0, arr, 0, arr.length);
    }

    public static void main(String[] args) {
        // Student ages for sorting
        int studentAges[] = new int[]{12, 15, 14, 13, 17, 16, 12, 18, 11, 10};
        int maxAge = 18;

        // Method call for sorting student ages
        countingSort(studentAges, maxAge);

        // Print sorted student ages
        System.out.println(Arrays.toString(studentAges));
    }
}
