package arrays.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a string and a pattern, find the smallest substring in the given string
 * which has all the characters of the given pattern.
 * ---
 * Solution:
 * ---
 * Time Complexity:
 * Space Complexity:
 */
public class SmallestWindowContainingSubstring {

    public static void main(String[] args) {
        assertEquals("abdec", smallestWindowContainingSubstring("aabdec", "abc"));
        assertEquals("abc", smallestWindowContainingSubstring("abdabca", "abc"));
        assertEquals("", smallestWindowContainingSubstring("adcad", "abc"));
    }

    private static String smallestWindowContainingSubstring(String s, String pattern) {
        int matchCount = 0;

        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            frequencies.merge(pattern.charAt(i), 1, Integer::sum);
        }

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if(frequencies.containsKey(s.charAt(windowEnd))) {
                frequencies.merge(s.charAt(windowEnd), 1, (prev, value) -> prev - value);
                if(frequencies.get(s.charAt(windowEnd)) == 0) {
                    matchCount++;
                }
            }

            while(matchCount == pattern.length()) {

            }
        }

        return "";
    }
}
