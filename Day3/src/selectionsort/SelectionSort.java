package selectionsort;

import java.util.Arrays;

public class SelectionSort {
    // Method for sorting array elements using Selection Sort
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        // Exam scores for sorting
        int examScores[] = new int[]{85, 72, 90, 65, 78, 88, 92, 70, 80, 60};

        // Method call for sorting exam scores
        selectionSort(examScores);

        // Print sorted exam scores
        System.out.println(Arrays.toString(examScores));
    }
}

