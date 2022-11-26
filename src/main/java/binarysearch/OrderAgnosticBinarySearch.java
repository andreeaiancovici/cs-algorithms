package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a sorted array of numbers, find if a given number ‘key’ is present in the array.
 * Though we know that the array is sorted, we don’t know if it’s sorted in ascending or descending order.
 * You should assume that the array can have duplicates.
 * <p>
 * Write a function to return the index of the ‘key’ if it is present in the array, otherwise return -1.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class OrderAgnosticBinarySearch {

    public static void main(String[] args) {
        assertEquals(2, binarySearch(new int[]{4, 6, 10}, 10));
        assertEquals(4, binarySearch(new int[]{1, 2, 3, 4, 5, 6, 7}, 5));
        assertEquals(0, binarySearch(new int[]{10, 6, 4}, 10));
        assertEquals(2, binarySearch(new int[]{10, 6, 4}, 4));
    }

    private static int binarySearch(int[] arr, int key) {
        boolean isAscending = arr[0] < arr[arr.length - 1];

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if ((isAscending && key <= arr[mid]) || (!isAscending && key >= arr[mid])) right = mid;
            else left = mid + 1;
        }

        return arr[left] == key ? left : -1;
    }
}
