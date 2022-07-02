package arrays.twopointers;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array with positive numbers and a target number,
 * find all of its contiguous sub-arrays whose product is less than the target number.
 * ---
 * Solution:
 * Two Pointers (actually Sliding Window)
 * ---
 * Time Complexity: O(n^3)
 * Space Complexity: O(n) for the temp list; O(n*(n+1)/2) = O(n^2) for the output list
 */
public class SubArraysWithProductLessThanATarget {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Collections.singletonList(2),
                Collections.singletonList(5),
                Arrays.asList(2, 5),
                Collections.singletonList(3),
                Arrays.asList(5, 3),
                Collections.singletonList(10)
        ), subArraysWithProductLessThanATarget(Arrays.asList(2, 5, 3, 10), 30));
        assertEquals(Arrays.asList(
                Collections.singletonList(8),
                Collections.singletonList(2),
                Arrays.asList(8, 2),
                Collections.singletonList(6),
                Arrays.asList(2, 6),
                Collections.singletonList(5),
                Arrays.asList(6, 5)
        ), subArraysWithProductLessThanATarget(Arrays.asList(8, 2, 6, 5), 50));
    }

    private static List<List<Integer>> subArraysWithProductLessThanATarget(List<Integer> array, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int product = 1, windowStart = 0;

        for (int windowEnd = 0; windowEnd < array.size(); windowEnd++) {
            product *= array.get(windowEnd);

            while (product >= target) {
                product /= array.get(windowStart++);
            }

            List<Integer> temp = new LinkedList<>();
            for (int i = windowEnd; i >= windowStart; i--) {
                temp.add(0, array.get(i));
                result.add(new ArrayList<>(temp));
            }
        }

        return result;
    }
}
