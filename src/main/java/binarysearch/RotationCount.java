package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
 * <p>
 * You can assume that the array does not have any duplicates.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class RotationCount {

    public static void main(String[] args) {
        assertEquals(2, binarySearch(new int[]{10, 15, 1, 3, 8}));
        assertEquals(5, binarySearch(new int[]{4, 5, 7, 9, 10, -1, 2}));
        assertEquals(0, binarySearch(new int[]{1, 3, 8, 10}));
    }

    private static int binarySearch(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) return 0;

        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (arr[mid] < arr[0]) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
