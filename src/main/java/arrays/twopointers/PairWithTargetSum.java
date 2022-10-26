package arrays.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.
 * Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PairWithTargetSum {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 3), pairWithTargetSum(Arrays.asList(1, 2, 3, 4, 6), 6));
        assertEquals(Arrays.asList(0, 2), pairWithTargetSum(Arrays.asList(2, 5, 9, 11), 11));
    }

    private static List<Integer> pairWithTargetSum(List<Integer> array, int target) {
        int start = 0, end = array.size() - 1;
        while (start < end) {
            int sum = array.get(start) + array.get(end);
            if (sum == target) {
                return Arrays.asList(start, end);
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }

        return Collections.emptyList();
    }
}
