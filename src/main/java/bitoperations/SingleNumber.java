package bitoperations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * In a non-empty array of integers, every number appears twice except for one, find that single number.
 * Assume the array is non-empty.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SingleNumber {

    public static void main(String[] args) {
        assertEquals(4, findSingleNumber(Arrays.asList(1, 4, 2, 1, 3, 2, 3)));
    }

    private static int findSingleNumber(List<Integer> arr) {
        int x = arr.get(0);

        for (int i = 1; i < arr.size(); i++) {
            x ^= arr.get(i);
        }

        return x;
    }
}
