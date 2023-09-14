package sorting.theory;

import java.util.Arrays;

/**
 * When to use it:
 * - complexity is not a problem
 * - simple code is preferred
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class _1_BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        bubbleSort(arr);
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void bubbleSort(int[] arr) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    isSorted = false;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
