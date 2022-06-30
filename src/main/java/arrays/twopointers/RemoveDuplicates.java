package arrays.twopointers;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of sorted numbers, remove all duplicates from it.
 * You should not use any extra space; after removing the duplicates in-place return the new length of the array.
 * ---
 * Solution:
 * Two Pointers
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        assertEquals(4, removeDuplicates(Arrays.asList(2, 3, 3, 3, 6, 9, 9)));
        assertEquals(2, removeDuplicates(Arrays.asList(2, 2, 2, 11)));
    }

    private static int removeDuplicates(List<Integer> array) {
        int indexToReplace = 1;

        for (int i = 1; i < array.size(); i++) {
            if (!array.get(i).equals(array.get(i - 1))) {
                array.set(indexToReplace++, array.get(i));
            }
        }

        return indexToReplace;
    }
}
