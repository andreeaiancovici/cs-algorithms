package sorting.theory;

import java.util.Arrays;

/**
 * When to use it:
 * - the array has a small number of elements
 * - there are only a few elements left to be sorted
 * ---
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class _2_InsertionSort {

    public static void main(String[] args) {
        int[] arr = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        insertionSort(arr);
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];

            int j = 0;
            while (j < i && arr[j] < num) j++;

            if (i - j >= 0) {
                System.arraycopy(arr, j, arr, j + 1, i - j);
                arr[j] = num;
            }
        }
    }
}
