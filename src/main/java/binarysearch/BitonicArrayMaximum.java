package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Find the maximum value in a given bitonic array. An array is considered bitonic if it is monotonically
 * increasing and then monotonically decreasing. Monotonically increasing or decreasing means that for
 * any index i in the array arr[i] != arr[i+1].
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class BitonicArrayMaximum {

    public static void main(String[] args) {
        assertEquals(12, binarySearch(new int[]{1, 3, 8, 12, 4, 2}));
        assertEquals(8, binarySearch(new int[]{3, 8, 3, 1}));
        assertEquals(12, binarySearch(new int[]{1, 3, 8, 12}));
        assertEquals(10, binarySearch(new int[]{10, 9, 8}));
    }

    private static int binarySearch(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] > arr[mid + 1]) right = mid;
            else left = mid + 1;
        }

        return arr[left];
    }
}
