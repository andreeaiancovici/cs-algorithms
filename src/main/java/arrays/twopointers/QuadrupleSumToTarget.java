package arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of unsorted numbers and a target number,
 * find all unique quadruplets in it, whose sum is equal to the target number.
 * ---
 * Solution:
 * Two Pointers
 * ---
 * Time Complexity: O(n * log(n) + n^3) -> O(n^3)
 * Space Complexity: O(n)
 */
public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Arrays.asList(-3, -1, 1, 4),
                Arrays.asList(-3, 1, 1, 2)
        ), quadrupleSumToTarget(Arrays.asList(4, 1, 2, -1, 1, -3), 1));
        assertEquals(Arrays.asList(
                Arrays.asList(-2, 0, 2, 2),
                Arrays.asList(-1, 0, 1, 2)
        ), quadrupleSumToTarget(Arrays.asList(2, 0, -1, 1, -2, 2), 2));
        assertEquals(Collections.emptyList(),
                quadrupleSumToTarget(Arrays.asList(1000000000, 1000000000, 1000000000, 1000000000), -294967296));
    }

    private static List<List<Integer>> quadrupleSumToTarget(List<Integer> array, int target) {
        if (array.size() == 0 || array.size() == 1 || array.size() == 2 || array.size() == 3) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Collections.sort(array);

        for (int i = 0; i < array.size() - 3; i++) {
            if (i > 0 && array.get(i - 1).equals(array.get(i))) {
                continue;
            }

            for (int j = i + 1; j < array.size() - 2; j++) {
                if (j > i + 1 && array.get(j - 1).equals(array.get(j))) {
                    continue;
                }

                int start = j + 1, end = array.size() - 1;
                while (start < end) {
                    long sum = (long) array.get(i) + array.get(j) + array.get(start) + array.get(end);

                    if (sum == target) {
                        result.add(Arrays.asList(array.get(i), array.get(j), array.get(start), array.get(end)));

                        do {
                            start++;
                        } while (start < end && array.get(start - 1).equals(array.get(start)));

                        do {
                            end--;
                        } while (start < end && array.get(end).equals(array.get(end + 1)));
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }
}
