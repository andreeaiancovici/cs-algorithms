package arrays.slidingwindow;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Question:
 * Given a string and a pattern, find out if the string contains any permutation of the pattern.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity:
 * Space Complexity:
 */
public class PermutationInAString {

    public static void main(String[] args) {
        assertTrue(permutationInAString("oidbcaf", "abc"));
        assertFalse(permutationInAString("odicf", "dc"));
        assertTrue(permutationInAString("bcdxabcdy", "bcdyabcdx"));
        assertTrue(permutationInAString("aaacb", "abc"));
        assertFalse(permutationInAString("ooolleoooleh", "hello"));
    }

    private static boolean permutationInAString(String s, String pattern) {
        int windowStart = 0, patternMatches = 0;
        Map<Character, Integer> patternFrequencies = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            patternFrequencies.merge(pattern.charAt(i), 1, Integer::sum);
        }

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (patternFrequencies.containsKey(s.charAt(windowEnd))) {
                patternFrequencies.merge(s.charAt(windowEnd), 1, (prev, value) -> prev - value);
                if(patternFrequencies.get(s.charAt(windowEnd)) == 0) {
                    patternMatches++;
                }
            }

            if(patternMatches == patternFrequencies.size()) {
                return true;
            }

            if(windowEnd - windowStart == pattern.length() - 1) {
                if (patternFrequencies.containsKey(s.charAt(windowStart))) {
                    if(patternFrequencies.get(s.charAt(windowStart)) == 0) {
                        patternMatches--;
                    }
                    patternFrequencies.merge(s.charAt(windowStart), 1, Integer::sum);
                }
                windowStart++;
            }
        }

        return false;
    }
}
