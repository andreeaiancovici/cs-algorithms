package arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a string, find the length of the longest substring in it with at most two distinct characters.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(k), k = distinct characters
 */
public class LongestSubstringWithAtMost2DistinctCharacters {

    public static void main(String[] args) {
        assertEquals(3, longestSubstringWithAtMost2DistinctCharacters("ABCAC"));
        assertEquals(5, longestSubstringWithAtMost2DistinctCharacters("ABCBBC"));
    }

    private static int longestSubstringWithAtMost2DistinctCharacters(String s) {
        Map<Character, Integer> frequencies = new HashMap<>();
        int windowStart = 0, maxLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            frequencies.merge(s.charAt(windowEnd), 1, Integer::sum);

            while (frequencies.size() > 2) {
                frequencies.merge(s.charAt(windowStart), 1, (prev, value) -> prev - value);

                if (frequencies.get(s.charAt(windowStart)) <= 0) {
                    frequencies.remove(s.charAt(windowStart));
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength + 1;
    }
}
