package binarysearch;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Given an array of numbers sorted in ascending order, find the range of a given number ‘key’.
 * The range of the ‘key’ will be the first and last position of the ‘key’ in the array.
 * <p>
 * Write a function to return the range of the ‘key’. If the ‘key’ is not present return [-1, -1].
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class NumberRange {

    public static void main(String[] args) {
        assertArrayEquals(new int[]{1, 3}, binarySearch(new int[]{4, 6, 6, 6, 9}, 6));
        assertArrayEquals(new int[]{3, 3}, binarySearch(new int[]{1, 3, 8, 10, 15}, 10));
        assertArrayEquals(new int[]{-1, -1}, binarySearch(new int[]{1, 3, 8, 10, 15}, 12));
    }

    private static int[] binarySearch(int[] arr, int key) {
        // find leftmost index of key
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (key <= arr[mid]) right = mid;
            else left = mid + 1;
        }

        if (key < arr[left]) return new int[]{-1, -1};

        int leftIndex = left;

        // find rightmost index of key
        left = 0;
        right = arr.length - 1;

        while (left < right) {
            int mid = (right - left + 1) / 2 + left;

            if (arr[mid] <= key) left = mid;
            else right = mid - 1;
        }

        return new int[]{leftIndex, left};
    }
}
