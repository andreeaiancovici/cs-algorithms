package arrays.mergeintervals;

import static org.junit.Assert.assertArrayEquals;

/**
 * Question:
 * Given two lists of intervals, find the intersection of these two lists.
 * Each list consists of disjoint intervals sorted on their start time.
 * ---
 * Time Complexity: O(m + n)
 * Space Complexity: O(p), where p is the number of intersecting intervals
 */
public class IntervalsIntersection {

    public static void main(String[] args) {
        assertArrayEquals(new int[][]{{2, 3}, {5, 6}, {7, 7}}, getIntervalsIntersection(new int[][]{{1, 3}, {5, 6}, {7, 9}}, new int[][]{{2, 3}, {5, 7}}));
        assertArrayEquals(new int[][]{{5, 7}, {9, 10}}, getIntervalsIntersection(new int[][]{{1, 3}, {5, 7}, {9, 12}}, new int[][]{{5, 10}}));
    }

    private static int[][] getIntervalsIntersection(int[][] arr1, int[][] arr2) {
        if (arr1 == null || arr2 == null) return new int[0][0];

        if (arr1.length == 0) return arr2;

        if (arr2.length == 0) return arr1;

        int[][] intervalIntersections = new int[arr1.length + arr2.length][2];

        int i = 0, j = 0, k = 0;
        while (i < arr1.length && j < arr2.length) {
            if ((arr1[i][0] <= arr2[j][0] && arr2[j][0] <= arr1[i][1]) || (arr2[j][0] <= arr1[i][0] && arr1[i][0] <= arr2[j][1])) {
                intervalIntersections[k][0] = Math.max(arr1[i][0], arr2[j][0]);
                intervalIntersections[k][1] = Math.min(arr1[i][1], arr2[j][1]);
                k++;
            }

            if (arr1[i][1] < arr2[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        if (k == intervalIntersections.length) return intervalIntersections;
        else {
            int[][] result = new int[k][2];
            for (int p = 0; p < k; p++) {
                result[p][0] = intervalIntersections[p][0];
                result[p][1] = intervalIntersections[p][1];
            }

            return result;
        }
    }
}
