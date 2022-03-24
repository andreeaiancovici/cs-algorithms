package bitwise;

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
 * Consider number N and its complement M.
 * N ^ M => results in a bit mask having all bits set to 1 and length equal to the left-most set bit between the 2 numbers
 * M = N ^ BIT_MASK, because XOR-ing a number with itself result 0, and XOR-ing a number with zero results itself
 * ---
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class ComplementOfBase10Number {

    public static void main(String[] args) {
        assertEquals(7, complementOfBase10Number(8));
        assertEquals(5, complementOfBase10Number(10));
    }

    private static int complementOfBase10Number(int n) {
        if(n == 0) {
            return 1;
        }

        // Compute bitmask of 1
        int bitMask = n;
        bitMask |= bitMask >> 1;
        bitMask |= bitMask >> 2;
        bitMask |= bitMask >> 4;
        bitMask |= bitMask >> 8;
        bitMask |= bitMask >> 16;

        // Extract the complement
        // BIT_MASK contains the number n XOR-ed with its complement
        return n ^ bitMask;
    }
}