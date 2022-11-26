package binarysearch;

import helper.array.ArrayReader;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an infinite sorted array (or an array with unknown size), find if a given number ‘key’
 * is present in the array. Write a function to return the index of the ‘key’ if it is present in the array,
 * otherwise return -1.
 * <p>
 * Since it is not possible to define an array with infinite (unknown) size, you will be provided with an interface
 * ArrayReader to read elements of the array. ArrayReader.get(index) will return the number at index; if the array’s
 * size is smaller than the index, it will return Integer.MAX_VALUE.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class SearchInASortedInfiniteArray {

    public static void main(String[] args) {
        assertEquals(6, binarySearch(new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}), 16));
        assertEquals(-1, binarySearch(new ArrayReader(new int[]{4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30}), 11));
        assertEquals(4, binarySearch(new ArrayReader(new int[]{1, 3, 8, 10, 15}), 15));
        assertEquals(-1, binarySearch(new ArrayReader(new int[]{1, 3, 8, 10, 15}), 200));
    }

    private static int binarySearch(ArrayReader arrayReader, int key) {
        // find size of array
        int left = 0, right = Integer.MAX_VALUE - 1;

        while (left < right) {
            int mid = (right - left + 1) / 2 + left;

            if (arrayReader.get(mid) < Integer.MAX_VALUE) left = mid;
            else right = mid - 1;
        }

        int size = left + 1;

        // check if key exists ina array
        left = 0;
        right = size - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (key <= arrayReader.get(mid)) right = mid;
            else left = mid + 1;
        }

        return arrayReader.get(left) == key ? left : -1;
    }
}
