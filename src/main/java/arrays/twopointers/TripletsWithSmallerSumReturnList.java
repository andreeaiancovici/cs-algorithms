package arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Write a function to return the list of all such triplets instead of the count.
 * How will the time complexity change in this case?
 * ---
 * Time Complexity: O(n * log(n) + n^3) -> O(n^3)
 * Space Complexity: O(n)
 */
public class TripletsWithSmallerSumReturnList {

    public static void main(String[] args) {
        List<List<Integer>> firstExpectedResult = Arrays.asList(
                Arrays.asList(-1, 0, 3),
                Arrays.asList(-1, 0, 2)
        );
        List<List<Integer>> firstResult = tripletsWithSmallerSumReturnList(Arrays.asList(-1, 0, 2, 3), 3);
        assertTrue(firstExpectedResult.size() == firstResult.size() &&
                firstExpectedResult.containsAll(firstResult) &&
                firstResult.containsAll(firstExpectedResult));

        List<List<Integer>> secondExpectedResult = Arrays.asList(
                Arrays.asList(-1, 1, 4),
                Arrays.asList(-1, 1, 3),
                Arrays.asList(-1, 1, 2),
                Arrays.asList(-1, 2, 3)
        );
        List<List<Integer>> secondResult = tripletsWithSmallerSumReturnList(Arrays.asList(-1, 4, 2, 1, 3), 5);
        assertTrue(secondExpectedResult.size() == secondResult.size() &&
                secondExpectedResult.containsAll(secondResult) &&
                secondResult.containsAll(secondExpectedResult));
    }

    private static List<List<Integer>> tripletsWithSmallerSumReturnList(List<Integer> array, int target) {
        if (array.isEmpty() || array.size() == 1 || array.size() == 2) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>();

        Collections.sort(array);

        for (int i = 0; i < array.size() - 2; i++) {
            int start = i + 1, end = array.size() - 1;
            while (start < end) {
                int sum = array.get(i) + array.get(start) + array.get(end);
                if (sum < target) {
                    for (int j = end; j > start; j--) {
                        if (j < end && array.get(j).equals(array.get(j + 1))) {
                            continue;
                        }
                        result.add(Arrays.asList(array.get(i), array.get(start), array.get(j)));
                    }
                    start++;
                } else {
                    end--;
                }
            }
        }

        return result;
    }
}
