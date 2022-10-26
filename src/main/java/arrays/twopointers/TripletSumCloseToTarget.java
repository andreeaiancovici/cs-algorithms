package arrays.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of unsorted numbers and a target number,
 * find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet.
 * If there are more than one such triplet, return the sum of the triplet with the smallest sum.
 * ---
 * Time Complexity: O(n * log(n) + n^2) -> O(n^2)
 * Space Complexity: O(n)
 */
public class TripletSumCloseToTarget {

    public static void main(String[] args) {
        assertEquals(1, tripletSumCloseToTarget(Arrays.asList(-2, 0, 1, 2), 2));
        assertEquals(0, tripletSumCloseToTarget(Arrays.asList(-3, -1, 1, 2), 1));
        assertEquals(3, tripletSumCloseToTarget(Arrays.asList(1, 0, 1, 1), 100));
    }

    private static int tripletSumCloseToTarget(List<Integer> array, int target) {
        if (array.isEmpty() || array.size() == 1 || array.size() == 2) {
            return -1;
        }

        Collections.sort(array);

        int smallestDiff = Integer.MAX_VALUE, smallestTripletSum = Integer.MAX_VALUE;

        for (int i = 0; i < array.size() - 2; i++) {
            int start = i + 1, end = array.size() - 1;
            while (start < end) {
                int sum = array.get(i) + array.get(start) + array.get(end);
                if (Math.abs(target - sum) < smallestDiff) {
                    smallestDiff = Math.abs(target - sum);
                    smallestTripletSum = sum;
                } else if (Math.abs(target - sum) == smallestDiff && sum < smallestTripletSum) {
                    smallestTripletSum = sum;
                }

                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return smallestTripletSum;
    }
}
