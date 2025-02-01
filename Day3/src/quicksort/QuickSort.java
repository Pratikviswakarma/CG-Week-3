package quicksort;

import java.util.Arrays;

public class QuickSort {
    // Method for sorting array elements using Quick Sort
    public static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int arr[], int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        // Product prices for sorting
        int productPrices[] = new int[]{450, 120, 700, 300, 600, 100, 500, 200, 400, 50};

        // Method call for sorting product prices
        quickSort(productPrices, 0, productPrices.length - 1);

        // Print sorted product prices
        System.out.println(Arrays.toString(productPrices));
    }
}

