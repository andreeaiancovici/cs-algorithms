package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a bitonic array, find if a given ‘key’ is present in it. An array is considered bitonic
 * if it is monotonically increasing and then monotonically decreasing. Monotonically increasing
 * or decreasing means that for any index i in the array arr[i] != arr[i+1].
 * <p>
 * Write a function to return the index of the ‘key’. If the ‘key’ is not present, return -1.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class SearchBitonicArray {

    public static void main(String[] args) {
        assertEquals(3, binarySearch(new int[]{1, 3, 8, 4, 3}, 4));
        assertEquals(1, binarySearch(new int[]{3, 8, 3, 1}, 8));
        assertEquals(3, binarySearch(new int[]{1, 3, 8, 12}, 12));
        assertEquals(0, binarySearch(new int[]{10, 9, 8, 10}, 10));
    }

    private static int binarySearch(int[] arr, int key) {
        // find max element in bitonic array
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] > arr[mid + 1]) right = mid;
            else left = mid + 1;
        }

        int peakIndex = left;

        // search from 0 to max element
        left = 0;
        right = peakIndex;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (key <= arr[mid]) right = mid;
            else left = mid + 1;
        }

        if (key == arr[left]) return left;

        // search from max element to end
        left = peakIndex + 1;
        right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (key <= arr[mid]) right = mid;
            else left = mid + 1;
        }

        return (key == arr[left]) ? left : -1;
    }
}
