package strings;

/*
  s = “adsgwadsxdsgwadsgz”
  p = “dsgwadsgz”
  Compute prefix-suffix table:
    | Index   | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 |
    | ------- | - | - | - | - | - | - | - | - | - |
    |         | 0 | 0 | 0 | 0 | 0 | 1 | 2 | 3 | 0 |
    | Pattern | d | s | g | w | a | d | s | g | z |

  Notice "dsg" which is a suffix but also a prefix.
  When we search through s and encounter a mismatch, we should start from the suffix index,
  because we already have “dsg” matched as a prefix.
  Last element from prefix-suffix table will give the length of the repeating prefix-suffix in pattern.
*/

import static org.junit.Assert.assertTrue;

/**
 * Time Complexity: O(n + m), where n is the size of the text and m is the size of the pattern
 * Space Complexity: O(m)
 */
public class KMP {

    public static void main(String[] args) {
        String text = "adsgwadsxdsgwadsgz";
        String pattern = "dsgwadsgz";

        assertTrue(kmp(text, pattern));
    }

    private static boolean kmp(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Compute prefix-suffix table for searched pattern
        int[] prefixSuffixTable = getPrefixSuffixTable(pattern, m);

        int i = 0, j = 0;
        while (i < n && j < m) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else if (0 < j) j = prefixSuffixTable[j - 1];
            else i++;
        }

        return j == m;
    }

    private static int[] getPrefixSuffixTable(String pattern, int m) {
        int[] prefixSuffixTable = new int[m];
        prefixSuffixTable[0] = 0;

        int j = 0, i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                prefixSuffixTable[i] = j + 1;
                i++;
                j++;
            } else if (0 < j) j = prefixSuffixTable[j - 1];
            else i++;
        }

        return prefixSuffixTable;
    }
}
