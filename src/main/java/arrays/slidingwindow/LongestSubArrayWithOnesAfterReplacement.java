package arrays.slidingwindow;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array containing 0s and 1s, if you are allowed to replace no more than K 0s with 1s,
 * find the length of the longest contiguous sub-array having all 1s.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class LongestSubArrayWithOnesAfterReplacement {

    public static void main(String[] args) {
        assertEquals(6, longestSubArrayWithOnesAfterReplacement(Arrays.asList(0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1), 2));
        assertEquals(9, longestSubArrayWithOnesAfterReplacement(Arrays.asList(0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1), 3));
    }

    private static int longestSubArrayWithOnesAfterReplacement(List<Integer> array, int K) {
        int windowStart = 0, maxLength = 0, replacedZeros = 0;

        for (int windowEnd = 0; windowEnd < array.size(); windowEnd++) {
            if (array.get(windowEnd) == 0) {
                replacedZeros++;
            }

            while (replacedZeros > K) {
                if (array.get(windowStart) == 0) {
                    replacedZeros--;
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
