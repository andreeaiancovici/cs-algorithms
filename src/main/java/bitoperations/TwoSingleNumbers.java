package bitoperations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * In a non-empty array of numbers, every number appears exactly twice except two numbers that appear only once.
 * Find the two numbers that appear only once.
 * ---
 * Solution:
 * XOR-ing the items in the input array will result in a XOR with the 2 single numbers.
 * Due to the fact that the 2 single numbers don't have a 0 XOR result, means that they have at least 1 different bit position.
 * The next step is to split the input array into 2 sub-groups:
 * - one which contains the different bit set to 1;
 * - one which contains the different bit set to 0.
 * In the end, the 2 sub-groups will result in the 2 single numbers, after applying XOR.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class TwoSingleNumbers {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(4, 6), findTwoSingleNumbers(Arrays.asList(1, 4, 2, 1, 3, 5, 6, 2, 3, 5)));
    }

    private static List<Integer> findTwoSingleNumbers(List<Integer> arr) {
        int n1xn2 = 0;
        for (int elem : arr) {
            n1xn2 ^= elem;
        }

        // Find the most right set bit
        int rightMostSetBit = n1xn2 & ~(n1xn2 - 1);

        int n1 = 0, n2 = 0;
        for (int elem : arr) {
            if ((elem & rightMostSetBit) == 0) n1 ^= elem;
            else n2 ^= elem;
        }

        return Arrays.asList(n1, n2);
    }
}
