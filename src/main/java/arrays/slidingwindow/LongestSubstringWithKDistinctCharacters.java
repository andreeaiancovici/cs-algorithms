package arrays.slidingwindow;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a string, find the length of the longest substring in it with no more than K distinct characters.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(K)
 */
public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        assertEquals(4, longestSubstringWithKDistinctCharacters("araaci", 2));
        assertEquals(2, longestSubstringWithKDistinctCharacters("araaci", 1));
        assertEquals(5, longestSubstringWithKDistinctCharacters("cbbebi", 3));
    }

    private static int longestSubstringWithKDistinctCharacters(String s, int K) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            frequencies.merge(s.charAt(windowEnd), 1, Integer::sum);

            if (frequencies.size() == K) {
                maxLength = Math.max(maxLength, windowEnd - windowStart);
            } else {
                while (frequencies.size() > K) {
                    frequencies.merge(s.charAt(windowStart), 1, (prev, value) -> prev - value);

                    if (frequencies.get(s.charAt(windowStart)) <= 0) {
                        frequencies.remove(s.charAt(windowStart));
                    }

                    windowStart++;
                }
            }
        }

        return maxLength + 1;
    }
}
