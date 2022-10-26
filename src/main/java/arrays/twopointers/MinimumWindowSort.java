package arrays.twopointers;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Question:
 * Given an array, find the length of the smallest sub-array in it which when sorted will sort the whole array.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class MinimumWindowSort {

    public static void main(String[] args) {
        assertEquals(5, minimumWindowSort(Arrays.asList(1, 2, 5, 3, 7, 10, 9, 12)));
        assertEquals(5, minimumWindowSort(Arrays.asList(1, 3, 2, 0, -1, 7, 10)));
        assertEquals(0, minimumWindowSort(Arrays.asList(1, 2, 3)));
        assertEquals(3, minimumWindowSort(Arrays.asList(3, 2, 1)));
    }

    private static int minimumWindowSort(List<Integer> array) {
        int start = 0, end = array.size() - 1;

        while (start < array.size() - 1) {
            if (array.get(start) > array.get(start + 1)) {
                break;
            } else {
                start++;
            }
        }

        if (start == array.size() - 1) {
            return 0;
        }

        while (0 < end) {
            if (array.get(end - 1) > array.get(end)) {
                break;
            } else {
                end--;
            }
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, array.get(i));
            min = Math.min(min, array.get(i));
        }

        int secondStart = 0;
        while (secondStart < start) {
            if (array.get(secondStart) > min) {
                break;
            }
            secondStart++;
        }

        int secondEnd = array.size() - 1;
        while (end < secondEnd) {
            if (array.get(secondEnd) < max) {
                break;
            }
            secondEnd--;
        }

        return secondEnd - secondStart + 1;
    }
}
