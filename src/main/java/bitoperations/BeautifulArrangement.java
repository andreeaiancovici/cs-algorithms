package bitoperations;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Suppose you have n integers labeled 1 through n.
 * A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 * - perm[i] is divisible by i.
 * - i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 * ---
 * Time Complexity: TBD
 * Space Complexity: TBD
 */
public class BeautifulArrangement {

    public static void main(String[] args) {
        assertEquals(10, countArrangement(5));
    }

    public static int countArrangement(int n) {
        Integer[] memo = new Integer[(1 << 16)];
        return dp(1, n, 0, memo);
    }

    private static int dp(int i, int n, int bitMask, Integer[] memo) {
        if (i == n + 1) return 1;

        if (memo[bitMask] != null) return memo[bitMask];

        int count = 0;

        for (int num = 1; num <= n; num++) {
            if (!(num % i == 0 || i % num == 0) || (bitMask & (1 << (num - 1))) != 0) continue;

            bitMask |= (1 << (num - 1));
            count += dp(i + 1, n, bitMask, memo);
            bitMask ^= (1 << (num - 1));
        }

        return memo[bitMask] = count;
    }
}
