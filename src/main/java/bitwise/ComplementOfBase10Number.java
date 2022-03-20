package bitwise;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Every non-negative integer N has a binary representation, for example,
 * 8 can be represented as “1000” in binary and 7 as “0111” in binary.
 * The complement of a binary representation is the number in binary
 * that we get when we change every 1 to a 0 and every 0 to a 1.
 * For example, the binary complement of “1010” is “0101”.
 * For a given positive number N in base-10, return the complement of its binary representation as a base-10 integer.
 * ---
 * Solution:
 * ---
 * Time Complexity:
 * Space Complexity:
 */
public class ComplementOfBase10Number {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(4, 6), complementOfBase10Number(Arrays.asList(1, 4, 2, 1, 3, 5, 6, 2, 3, 5)));
    }

    private static int complementOfBase10Number(List<Integer> arr) {
        return 0;
    }
}