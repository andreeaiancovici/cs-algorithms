package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of numbers sorted in ascending order,
 * find the element in the array that has the minimum difference with the given ‘key’.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class MinimumDifferenceElement {

    public static void main(String[] args) {
        assertEquals(6, binarySearch(new int[]{4, 6, 10}, 7));
        assertEquals(4, binarySearch(new int[]{4, 6, 10}, 4));
        assertEquals(10, binarySearch(new int[]{1, 3, 8, 10, 15}, 12));
        assertEquals(10, binarySearch(new int[]{4, 6, 10}, 17));
    }

    private static int binarySearch(int[] arr, int key) {
        if (key < arr[0]) return arr[0];
        if (arr[arr.length - 1] < key) return arr[arr.length - 1];

        // find leftmost min diff arr[i] - key
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (0 <= arr[mid] - key) right = mid;
            else left = mid + 1;
        }

        int leftMostIndex = left;

        // find rightmost min diff key - arr[i]
        left = 0;
        right = arr.length - 1;

        while (left < right) {
            int mid = (right - left + 1) / 2 + left;

            if (arr[mid] - key <= 0) left = mid;
            else right = mid - 1;
        }

        return (arr[leftMostIndex] - key) < (key - arr[left]) ? arr[leftMostIndex] : arr[left];
    }
}
