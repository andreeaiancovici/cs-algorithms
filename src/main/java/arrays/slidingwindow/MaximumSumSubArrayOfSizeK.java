package arrays.slidingwindow;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of positive numbers and a positive number k,
 * find the maximum sum of any contiguous sub-array of size k.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MaximumSumSubArrayOfSizeK {

    public static void main(String[] args) {
        assertEquals(9, maximumSumSubArrayOfSizeK(Arrays.asList(2, 1, 5, 1, 3, 2), 3));
        assertEquals(7, maximumSumSubArrayOfSizeK(Arrays.asList(2, 3, 4, 1, 5), 2));
    }

    private static int maximumSumSubArrayOfSizeK(List<Integer> array, int k) {
        int windowStart = 0, sum = 0, maxSum = 0;

        for(int windowEnd = 0; windowEnd < array.size(); windowEnd++) {
            sum += array.get(windowEnd);
            if(windowEnd - windowStart == k - 1) {
                maxSum = Math.max(maxSum, sum);
                sum -= array.get(windowStart);
                windowStart++;
            }
        }

        return maxSum;
    }
}
