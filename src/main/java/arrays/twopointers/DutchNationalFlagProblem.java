package arrays.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array containing 0s, 1s and 2s, sort the array in-place.
 * You should treat numbers of the array as objects, hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class DutchNationalFlagProblem {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(0, 0, 1, 1, 2), dutchNationalFlagProblem(Arrays.asList(1, 0, 2, 1, 0)));
        assertEquals(Arrays.asList(0, 0, 1, 2, 2, 2), dutchNationalFlagProblem(Arrays.asList(2, 2, 0, 1, 2, 0)));
    }

    private static List<Integer> dutchNationalFlagProblem(List<Integer> array) {
        int zero = 0, one = 0, two = array.size() - 1;

        while (one <= two) {
            if (array.get(one) == 0) {
                Collections.swap(array, one++, zero++);
            } else if (array.get(one) == 1) {
                one++;
            } else {
                Collections.swap(array, one, two--);
            }
        }

        return array;
    }
}
