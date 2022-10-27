package arrays.mergeintervals;

import java.util.*;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Given a list of intervals, merge all the overlapping intervals to
 * produce a list that has only mutually exclusive intervals.
 * ---
 * Time Complexity: O(n * log(n))
 * Space Complexity: O(n)
 */
public class MergeIntervals {

    public static void main(String[] args) {
        assertArrayEquals(new int[][]{{1, 5}, {7, 9}}, mergeIntervals(new int[][]{{1, 4}, {2, 5}, {7, 9}}));
        assertArrayEquals(new int[][]{{2, 4}, {5, 9}}, mergeIntervals(new int[][]{{6, 7}, {2, 4}, {5, 9}}));
        assertArrayEquals(new int[][]{{1, 6}}, mergeIntervals(new int[][]{{1, 4}, {2, 6}, {3, 5}}));
    }

    private static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;

        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));

        int[][] mergedIntervals = new int[intervals.length][2];
        int j = 0;
        mergedIntervals[j] = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int prevUpper = mergedIntervals[j][1];

            int lower = intervals[i][0];
            int upper = intervals[i][1];

            if (prevUpper < lower) {
                mergedIntervals[++j] = intervals[i];
            }

            if (lower <= prevUpper && prevUpper < upper) {
                mergedIntervals[j][1] = upper;
            }
        }

        int[][] result = new int[j + 1][2];
        for (int i = 0; i <= j; i++) {
            result[i][0] = mergedIntervals[i][0];
            result[i][1] = mergedIntervals[i][1];
        }

        return result;
    }
}
