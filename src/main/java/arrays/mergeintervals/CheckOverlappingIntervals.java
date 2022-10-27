package arrays.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Given a set of intervals, find out if any two intervals overlap.
 * ---
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 */
public class CheckOverlappingIntervals {

    public static void main(String[] args) {
        assertTrue(areIntervalsOverlapping(new int[][]{{1, 4}, {2, 5}, {7, 9}}));
        assertTrue(areIntervalsOverlapping(new int[][]{{6, 7}, {2, 4}, {5, 9}}));
        assertTrue(areIntervalsOverlapping(new int[][]{{1, 4}, {2, 6}, {3, 5}}));
        assertFalse(areIntervalsOverlapping(new int[][]{{1, 4}, {5, 6}}));
    }

    private static boolean areIntervalsOverlapping(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return false;

        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        for (int i = 1; i < intervals.length; i++) {
            int prevUpper = intervals[i - 1][1];
            int lower = intervals[i][0];

            if (lower <= prevUpper) return true;
        }

        return false;
    }
}
