package binarysearch;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array
 * greater than a given ‘key’.
 * <p>
 * Assume the given array is a circular list, which means that the last letter is assumed to be
 * connected with the first letter. This also means that the smallest letter in the given array
 * is greater than the last letter of the array and is also the first letter of the array.
 * <p>
 * Write a function to return the next letter of the given ‘key’.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class NextLetter {

    public static void main(String[] args) {
        assertEquals('h', binarySearch(new char[]{'a', 'c', 'f', 'h'}, 'f'));
        assertEquals('c', binarySearch(new char[]{'a', 'c', 'f', 'h'}, 'b'));
        assertEquals('a', binarySearch(new char[]{'a', 'c', 'f', 'h'}, 'm'));
        assertEquals('a', binarySearch(new char[]{'a', 'c', 'f', 'h'}, 'h'));
    }

    private static char binarySearch(char[] arr, char key) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = (right - left) / 2 + left;

            if (key <= arr[mid]) right = mid;
            else left = mid + 1;
        }

        if (key < arr[left]) return arr[left];

        if (left < arr.length - 1) left++;
        else left = 0;

        return arr[left];
    }
}
