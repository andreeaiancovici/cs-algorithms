package arrays.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a sorted array, create a new array containing squares of all the number
 * of the input array in the sorted order.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class SquaringASortedArray {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(0, 1, 4, 4, 9), squaringASortedArray(Arrays.asList(-2, -1, 0, 2, 3)));
        assertEquals(Arrays.asList(0, 1, 1, 4, 9), squaringASortedArray(Arrays.asList(-3, -1, 0, 1, 2)));
    }

    private static List<Integer> squaringASortedArray(List<Integer> array) {
        List<Integer> squaredArray = new ArrayList<>(Collections.nCopies(array.size(), 0));

        int start = 0, end = array.size() - 1;
        int reversedIndex = squaredArray.size() - 1;
        while (start < end) {
            int startSquare = array.get(start) * array.get(start);
            int endSquare = array.get(end) * array.get(end);

            if (startSquare > endSquare) {
                squaredArray.set(reversedIndex--, startSquare);
                start++;
            } else {
                squaredArray.set(reversedIndex--, endSquare);
                end--;
            }
        }

        return squaredArray;
    }
}
