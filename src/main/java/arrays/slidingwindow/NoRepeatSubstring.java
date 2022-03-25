package arrays.slidingwindow;


import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a string, find the length of the longest substring which has no repeating characters.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1), only 26 english characters
 */
public class NoRepeatSubstring {

    public static void main(String[] args) {
        assertEquals(3, noRepeatSubstring("aabccbb"));
        assertEquals(2, noRepeatSubstring("abbbb"));
        assertEquals(3, noRepeatSubstring("abccde"));
    }

    private static int noRepeatSubstring(String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        int windowStart = 0, maxLength = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            Integer index = charToIndex.get(s.charAt(windowEnd));

            if (index != null) {
                Integer startIndex = charToIndex.get(s.charAt(windowStart));
                while (startIndex != null && startIndex <= index) {
                    charToIndex.remove(s.charAt(windowStart));
                    windowStart++;
                    startIndex = charToIndex.get(s.charAt((windowStart)));
                }
            }

            charToIndex.put(s.charAt(windowEnd), windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
