package arrays.mergeintervals;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Given a list of non-overlapping intervals sorted by their start time, insert a given interval
 * at the correct position and merge all necessary intervals to produce a list that has only mutually
 * exclusive intervals.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

public class InsertInterval {

    public static void main(String[] args) {
        assertArrayEquals(new int[][]{{1, 3}, {4, 7}, {8, 12}}, insertInterval(new int[][]{{1, 3}, {5, 7}, {8, 12}}, new int[]{4, 6}));
        assertArrayEquals(new int[][]{{1, 3}, {4, 12}}, insertInterval(new int[][]{{1, 3}, {5, 7}, {8, 12}}, new int[]{4, 10}));
        assertArrayEquals(new int[][]{{1, 4}, {5, 7}}, insertInterval(new int[][]{{2, 3}, {5, 7}}, new int[]{1, 4}));
        assertArrayEquals(new int[][]{{2, 3}, {4, 5}, {6, 7}}, insertInterval(new int[][]{{2, 3}, {6, 7}}, new int[]{4, 5}));
    }

    private static int[][] insertInterval(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) return new int[][]{newInterval};

        int[][] mergedIntervals = new int[intervals.length + 1][2];
        int k = 0, i = 0;
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            mergedIntervals[k++] = intervals[i++];
        }

        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        mergedIntervals[k++] = newInterval;

        while (i < intervals.length) {
            mergedIntervals[k++] = intervals[i++];
        }

        if (k == mergedIntervals.length) return mergedIntervals;
        else {
            int[][] result = new int[k][2];
            for (int j = 0; j < k; j++) {
                result[j][0] = mergedIntervals[j][0];
                result[j][1] = mergedIntervals[j][1];
            }

            return result;
        }
    }
}
