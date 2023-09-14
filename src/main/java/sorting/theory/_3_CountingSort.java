package sorting.theory;

import java.util.Arrays;

/**
 * When to use it:
 * - the array contains smaller integers with multiple counts
 * - linear complexity is required
 * ---
 * Time Complexity: O(n + k), where k is the length of the count array
 * Space Complexity: O(max), where max is the maximum element in the array
 */
public class _3_CountingSort {

    public static void main(String[] args) {
        int[] arr = new int[]{61, 42, 67, 27, 17, 75, 56, 93, 76, 46, 63, 55, 70, 59, 98, 9, 7, 67, 95, 90};
        countingSort(arr);
        Arrays.stream(arr).forEach(num -> System.out.print(num + " "));
    }

    private static void countingSort(int[] arr) {
        int[] count = new int[100];
        for (int num : arr) {
            count[num]++;
        }

        int k = 0;
        for (int i = 0; i < count.length; i++) {
            while (0 < count[i]) {
                arr[k++] = i;
                count[i]--;
            }
        }
    }
}
