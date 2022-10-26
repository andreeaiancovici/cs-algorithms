package arrays.slidingwindow;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a string with lowercase letters only, if you are allowed to replace no more than K letters with any letter,
 * find the length of the longest substring having the same letters after replacement.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1), only 26 english characters
 */
public class LongestSubstringWithSameLettersAfterReplacement {

    public static void main(String[] args) {
        assertEquals(5, longestSubstringWithSameLettersAfterReplacement("aabccbb", 2));
        assertEquals(4, longestSubstringWithSameLettersAfterReplacement("abbcb", 1));
        assertEquals(3, longestSubstringWithSameLettersAfterReplacement("abccde", 1));
    }

    private static int longestSubstringWithSameLettersAfterReplacement(String s, int K) {
        int windowStart = 0, maxRepeatedLetter = 0, maxLength = 0;
        Map<Character, Integer> frequencies = new HashMap<>();

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            frequencies.merge(s.charAt(windowEnd), 1, Integer::sum);
            maxRepeatedLetter = Math.max(maxRepeatedLetter, frequencies.get(s.charAt(windowEnd)));

            if (windowEnd - windowStart + 1 - maxRepeatedLetter > K) {
                frequencies.merge(s.charAt(windowStart), 1, (prev, value) -> prev - value);
                if (frequencies.get(s.charAt(windowStart)) <= 0) {
                    frequencies.remove(s.charAt(windowStart));
                }
                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
