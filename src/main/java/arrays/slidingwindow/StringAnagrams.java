package arrays.slidingwindow;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Question:
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 * Write a function to return a list of starting indices of the anagrams of the pattern in the given string.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(N + M), where N is the size of input string and M is the size of pattern
 * Space Complexity: O(K), where K is the number of distinct characters in pattern
 */
public class StringAnagrams {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 2), stringAnagrams("ppqp", "pq"));
        assertEquals(Arrays.asList(2, 3, 4), stringAnagrams("abbcabc", "abc"));
    }

    private static List<Integer> stringAnagrams(String s, String pattern) {
        List<Integer> indexes = new ArrayList<>();
        int windowStart = 0, matchesCount = 0;

        Map<Character, Integer> frequencies = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            frequencies.merge(pattern.charAt(i), 1, Integer::sum);
        }

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            if (frequencies.containsKey(s.charAt(windowEnd))) {
                frequencies.merge(s.charAt(windowEnd), 1, (prev, value) -> prev - value);
                if (frequencies.get(s.charAt(windowEnd)) == 0) {
                    matchesCount++;
                }
            }

            if (frequencies.size() == matchesCount) {
                indexes.add(windowEnd - pattern.length() + 1);
            }

            if (windowEnd - windowStart == pattern.length() - 1) {
                if (frequencies.containsKey(s.charAt(windowStart))) {
                    if (frequencies.get(s.charAt(windowStart)) == 0) {
                        matchesCount--;
                    }
                    frequencies.merge(s.charAt(windowStart), 1, Integer::sum);
                }
                windowStart++;

            }
        }

        return indexes;
    }
}
