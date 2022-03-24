package arrays.slidingwindow;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of positive numbers and a positive number S,
 * find the length of the smallest contiguous sub-array whose sum is greater than or equal to S.
 * Return 0, if no such sub-array exists.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SmallestSubArrayWithGivenSum {

    public static void main(String[] args) {
        assertEquals(2, smallestSubArrayWithGivenSum(Arrays.asList(2, 1, 5, 2, 3, 2), 7));
        assertEquals(1, smallestSubArrayWithGivenSum(Arrays.asList(2, 1, 5, 2, 8), 7));
        assertEquals(3, smallestSubArrayWithGivenSum(Arrays.asList(3, 4, 1, 1, 6), 8));
    }

    private static int smallestSubArrayWithGivenSum(List<Integer> array, int S) {
        int windowStart = 0, minLength = array.size(), sum = 0;
        for (int windowEnd = 0; windowEnd < array.size(); windowEnd++) {
            sum += array.get(windowEnd);
            while (sum >= S) {
                minLength = Math.min(minLength, windowEnd - windowStart);
                sum -= array.get(windowStart);
                windowStart++;
            }
        }
        return minLength + 1;
    }
}
