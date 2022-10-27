package arrays.fastslowpointers;

import static org.junit.Assert.*;

/**
 * Question:
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to
 * the sum of the square of all of its digits, leads us to number ‘1’.
 * All other (not-happy) numbers will never reach ‘1’. Instead, they will be stuck in a cycle of numbers
 * which does not include ‘1’.
 * ---
 * Time Complexity: O(log(n))
 * Space Complexity: O(1)
 */
public class HappyNumber {

    public static void main(String[] args) {
        assertTrue(isHappy(23));
        assertFalse(isHappy(12));
    }

    private static boolean isHappy(int n) {
        int slowN = n, fastN = n;

        do {
            slowN = findSumSquareOfDigits(slowN);

            if (slowN == 1) return true;

            fastN = findSumSquareOfDigits(findSumSquareOfDigits(fastN));

            if (fastN == 1) return true;
        } while (slowN != fastN);

        return false;
    }

    private static int findSumSquareOfDigits(int n) {
        int sum = 0;

        while (n != 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }

        return sum;
    }
}
