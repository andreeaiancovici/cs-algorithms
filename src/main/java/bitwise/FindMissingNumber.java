package bitwise;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of n−1 integers in the range from 1 to n, find the one number that is missing from the array.
 * Assume the array is non-empty.
 * ---
 * Solution:
 * Applying XOR between 2 identical numbers will result 0.
 * Compute XOR result from 1 to n.
 * Compute XOR result from input array.
 * Computer XOR between the 2 result found earlier.
 * The only number which won't be XOR-ed with its duplicate is the one that is missing.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        assertEquals(3, findMissingNumber(Arrays.asList(1, 5, 2, 6, 4)));
    }

    private static int findMissingNumber(List<Integer> arr) {
        int n = arr.size();

        int x1 = 1;
        for (int i = 2; i <= n + 1; i++) {
            x1 ^= i;
        }

        int x2 = arr.get(0);
        for (int i = 1; i < n; i++) {
            x2 ^= arr.get(i);
        }

        // All numbers XOR-ed in x1 will result 0 when XOR-ed with x2,
        // leaving the missing number contained in the first XOR result behind
        return x1 ^ x2;
    }
}
