package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of numbers sorted in an ascending order, find the ceiling of a given number ‘key’.
 * The ceiling of the ‘key’ will be the smallest element in the given array greater than or equal to the ‘key’.
 * <p>
 * Write a function to return the index of the ceiling of the ‘key’. If there isn’t any ceiling return -1.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class CeilingOfANumber {

    public static void main(String[] args) {
        assertEquals(1, binarySearch(new int[]{4, 6, 10}, 6));
        assertEquals(4, binarySearch(new int[]{1, 3, 8, 10, 15}, 12));
        assertEquals(-1, binarySearch(new int[]{4, 6, 10}, 17));
        assertEquals(0, binarySearch(new int[]{4, 6, 10}, -1));
    }

    private static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (key <= arr[mid]) right = mid;
            else left = mid + 1;
        }

        return key <= arr[left] ? left : -1;
    }
}
