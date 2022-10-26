package arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
 * ---
 * Time Complexity: O(n * log(n) + n^2) -> O(n^2)
 * Space Complexity: O(n)
 */
public class TripletSumToZero {

    public static void main(String[] args) {
        List<List<Integer>> firstExpectedResult = Arrays.asList(
                Arrays.asList(-3, 1, 2),
                Arrays.asList(-2, 0, 2),
                Arrays.asList(-2, 1, 1),
                Arrays.asList(-1, 0, 1)
        );
        List<List<Integer>> firstResult = tripletSumToZero(Arrays.asList(-3, 0, 1, 2, -1, 1, -2));
        assertTrue(firstExpectedResult.size() == firstResult.size() &&
                firstExpectedResult.containsAll(firstResult) &&
                firstResult.containsAll(firstExpectedResult));

        List<List<Integer>> secondExpectedResult = Arrays.asList(
                Arrays.asList(-5, 2, 3),
                Arrays.asList(-2, -1, 3)
        );
        List<List<Integer>> secondResult = tripletSumToZero(Arrays.asList(-5, 2, -1, -2, 3));
        assertTrue(secondExpectedResult.size() == secondResult.size() &&
                secondExpectedResult.containsAll(secondResult) &&
                secondResult.containsAll(secondExpectedResult));
    }

    private static List<List<Integer>> tripletSumToZero(List<Integer> array) {
        List<List<Integer>> result = new ArrayList<>();

        if (array.isEmpty() || array.size() == 1 || array.size() == 2) {
            return result;
        }

        //n * log(n) -> improved version of MergeSort
        Collections.sort(array);

        for (int i = 0; i < array.size() - 2; i++) {
            if (i > 0 && array.get(i - 1).equals(array.get(i))) {
                continue;
            }
            int start = i + 1, end = array.size() - 1;
            while (start < end) {
                int num = array.get(i) + array.get(start) + array.get(end);
                if (num == 0) {
                    result.add(Arrays.asList(array.get(i), array.get(start), array.get(end)));
                    do {
                        start++;
                    } while (start < end && array.get(start - 1).equals(array.get(start)));
                    do {
                        end--;
                    } while (start < end && array.get(end).equals(array.get(end + 1)));
                } else if (num < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }
}
