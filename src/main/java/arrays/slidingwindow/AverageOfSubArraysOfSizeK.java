package arrays.slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array, find the average of all contiguous sub-arrays of size k in it.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class AverageOfSubArraysOfSizeK {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(2.2, 2.8, 2.4, 3.6, 2.8),
                averagesOfSubArraysOfSizeK(Arrays.asList(1, 3, 2, 6, -1, 4, 1, 8, 2), 5));
    }

    private static List<Double> averagesOfSubArraysOfSizeK(List<Integer> array, int k) {
        List<Double> averages = new ArrayList<>();

        int windowStart = 0, sum = 0;
        for (int windowEnd = 0; windowEnd < array.size(); windowEnd++) {
            sum += array.get(windowEnd);
            if (windowEnd - windowStart == k - 1) {
                averages.add(((double) sum) / k);
                sum -= array.get(windowStart);
                windowStart++;
            }
        }

        return averages;
    }
}
