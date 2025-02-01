package insertionsort;

import java.util.Arrays;

public class InsertionSort {
    // Method for sorting array elements using Insertion Sort
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        // Employee IDs for sorting
        int employeeIDs[] = new int[]{1023, 456, 789, 234, 567, 345, 678, 123, 890, 901};

        // Method call for sorting employee IDs
        insertionSort(employeeIDs);

        // Print sorted employee IDs
        System.out.println(Arrays.toString(employeeIDs));
    }
}
