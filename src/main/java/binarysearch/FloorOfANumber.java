package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of numbers sorted in ascending order, find the floor of a given number ‘key’.
 * The floor of the ‘key’ will be the biggest element in the given array smaller than or equal to the ‘key’
 * <p>
 * Write a function to return the index of the floor of the ‘key’. If there isn’t a floor, return -1.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class FloorOfANumber {

    public static void main(String[] args) {
        assertEquals(1, binarySearch(new int[]{4, 6, 10}, 6));
        assertEquals(3, binarySearch(new int[]{1, 3, 8, 10, 15}, 12));
        assertEquals(2, binarySearch(new int[]{4, 6, 10}, 17));
        assertEquals(-1, binarySearch(new int[]{4, 6, 10}, -1));
    }

    private static int binarySearch(int[] arr, int key) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left + 1) / 2 + left;

            if (arr[mid] <= key) left = mid;
            else right = mid - 1;
        }

        return arr[left] <= key ? left : -1;
    }
}
