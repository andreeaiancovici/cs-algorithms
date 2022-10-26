package arrays.twopointers;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an unsorted array of numbers and a target ‘key’,
 * remove all instances of ‘key’ in-place and return the new length of the array.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class RemoveAllKey {

    public static void main(String[] args) {
        assertEquals(4, removeDuplicates(Arrays.asList(3, 2, 3, 6, 3, 10, 9, 3), 3));
        assertEquals(2, removeDuplicates(Arrays.asList(2, 11, 2, 2, 1), 2));
    }

    private static int removeDuplicates(List<Integer> array, int key) {
        int indexToReplace = 0;

        for (int i = 0; i < array.size(); i++) {
            if (!array.get(i).equals(key)) {
                array.set(indexToReplace++, array.get(i));
            }
        }

        return indexToReplace;
    }
}
