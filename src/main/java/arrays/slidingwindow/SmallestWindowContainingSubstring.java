package arrays.slidingwindow;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a string and a pattern, find the smallest substring in the given string
 * which has all the characters of the given pattern.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SmallestWindowContainingSubstring {

    public static void main(String[] args) {
        assertEquals("abdec", smallestWindowContainingSubstring("aabdec", "abc"));
        assertEquals("abc", smallestWindowContainingSubstring("abdabca", "abc"));
        assertEquals("", smallestWindowContainingSubstring("adcad", "abc"));
    }

    private static String smallestWindowContainingSubstring(String s, String pattern) {
        Map<Character, Integer> frequencies = new HashMap<>();
        Map<Character, Integer> patternFrequencies = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            patternFrequencies.put(pattern.charAt(i), patternFrequencies.getOrDefault(pattern.charAt(i), 0) + 1);
        }

        int countPatternChars = 0;
        int windowStart = 0, minLength = Integer.MAX_VALUE;
        int start = 0, end = -1;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            frequencies.put(s.charAt(windowEnd), frequencies.getOrDefault(s.charAt(windowEnd), 0) + 1);

            if (patternFrequencies.containsKey(s.charAt(windowEnd)) && frequencies.get(s.charAt(windowEnd)) <= patternFrequencies.get(s.charAt(windowEnd))) {
                countPatternChars++;
            }

            while (countPatternChars == pattern.length()) {
                if ((windowEnd - windowStart + 1) < minLength) {
                    start = windowStart;
                    end = windowEnd;
                    minLength = windowEnd - windowStart + 1;
                }

                if (patternFrequencies.containsKey(s.charAt(windowStart)) && frequencies.get(s.charAt(windowStart)) <= patternFrequencies.get(s.charAt(windowStart))) {
                    countPatternChars--;
                }

                Integer frequency = frequencies.get(s.charAt(windowStart));
                if (frequency == 1) {
                    frequencies.remove(s.charAt(windowStart));
                } else {
                    frequencies.put(s.charAt(windowStart), --frequency);
                }

                windowStart++;
            }
        }

        return s.substring(start, end + 1);
    }
}
