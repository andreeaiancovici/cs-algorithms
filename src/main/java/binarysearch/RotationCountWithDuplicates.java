package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of numbers which is sorted in ascending order and is rotated ‘k’ times around a pivot, find ‘k’.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class RotationCountWithDuplicates {

    public static void main(String[] args) {
        assertEquals(3, binarySearch(new int[]{3, 3, 7, 3}));
    }

    private static int binarySearch(int[] arr) {
        if (arr[0] < arr[arr.length - 1]) return 0;

        // find rotation index
        int left = 0, right = arr.length - 1;

        while (left < right) {
            while (arr[left] == arr[right] && left < right) left++;
            int mid = (right - left) / 2 + left;

            if (arr[mid] <= arr[right]) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}
