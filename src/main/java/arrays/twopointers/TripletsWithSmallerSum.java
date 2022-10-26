package arrays.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array arr of unsorted numbers and a target sum, count all triplets in it such that
 * arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices.
 * Write a function to return the count of such triplets.
 * ---
 * Time Complexity: O(n * log(n) + n^2) -> O(n^2)
 * Space Complexity: O(n)
 */
public class TripletsWithSmallerSum {

    public static void main(String[] args) {
        assertEquals(2, tripletsWithSmallerSum(Arrays.asList(-1, 0, 2, 3), 3));
        assertEquals(4, tripletsWithSmallerSum(Arrays.asList(-1, 4, 2, 1, 3), 5));
    }

    private static int tripletsWithSmallerSum(List<Integer> array, int target) {
        if (array.isEmpty() || array.size() == 1 || array.size() == 2) {
            return 0;
        }

        int count = 0;

        Collections.sort(array);

        for (int i = 0; i < array.size() - 2; i++) {
            int start = i + 1, end = array.size() - 1;
            while (start < end) {
                int sum = array.get(i) + array.get(start) + array.get(end);
                if (sum < target) {
                    count += end - start;
                    start++;
                } else {
                    end--;
                }
            }
        }

        return count;
    }
}
