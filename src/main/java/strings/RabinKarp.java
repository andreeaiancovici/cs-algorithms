package strings;

import static org.junit.Assert.assertTrue;

/*
    Rolling Hash
    A good hash function makes the algorithm run in linear time,
    by avoiding un-necessary string check on hash collisions.
*/

/**
 * Time Complexity: O(n + m), where n is the size of the text and m is the size of the pattern
 * Space Complexity: O(m)
 */
public class RabinKarp {

    public static void main(String[] args) {
        String text = "adsgwadsxdsgwadsgz";
        String pattern = "dsgwadsgz";

        assertTrue(rabinKarp(text, pattern));
    }

    private static boolean rabinKarp(String text, String pattern) {
        if (pattern.length() > text.length()) return false;

        int BASE = 31;
        int MOD = (int) 1e9 + 7;

        long powerBASE = 1;
        long textHash = 0;
        long patternHash = 0;

        for (int i = 0; i < pattern.length(); i++) {
            powerBASE = (powerBASE * BASE) % MOD;
            textHash = (textHash * BASE + (text.charAt(i) - 'a')) % MOD;
            patternHash = (patternHash * BASE + (pattern.charAt(i) - 'a')) % MOD;
        }

        for (int i = pattern.length(); i < text.length(); i++) {
            if (textHash == patternHash && checkCollision(text, i, pattern)) return true;

            textHash = (textHash * BASE + (text.charAt(i) - 'a')) % MOD;
            textHash = (textHash - ((text.charAt(i - pattern.length()) - 'a') * powerBASE) % MOD + MOD) % MOD;
        }

        return textHash == patternHash && checkCollision(text, text.length(), pattern);
    }

    private static boolean checkCollision(String text, int i, String pattern) {
        return text.startsWith(pattern, i - pattern.length());
    }
}
