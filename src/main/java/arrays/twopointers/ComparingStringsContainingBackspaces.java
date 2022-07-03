package arrays.twopointers;

import static org.junit.Assert.*;

/**
 * Question:
 * Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.
 * ---
 * Solution:
 * ---
 * Time Complexity: O(n + m)
 * Space Complexity: O(1)
 */
public class ComparingStringsContainingBackspaces {

    public static void main(String[] args) {
        assertTrue(comparingStringsContainingBackspaces("xy#z", "xzz#"));
        assertFalse(comparingStringsContainingBackspaces("xy#z", "xyz#"));
        assertTrue(comparingStringsContainingBackspaces("xp#", "xyz##"));
        assertTrue(comparingStringsContainingBackspaces("xywrrmp", "xywrrmu#p"));
    }

    private static boolean comparingStringsContainingBackspaces(String s1, String s2) {
        int s1Index = s1.length() - 1, s2Index = s2.length() - 1;

        while (s1Index >= 0 || s2Index >= 0) {
            s1Index = findNextCharIndex(s1, s1Index);
            s2Index = findNextCharIndex(s2, s2Index);

            char c1 = s1Index >= 0 ? s1.charAt(s1Index) : '\0';
            char c2 = s2Index >= 0 ? s2.charAt(s2Index) : '\0';

            if (c1 != c2) {
                return false;
            }

            s1Index--;
            s2Index--;
        }

        return true;
    }

    private static int findNextCharIndex(String s, int index) {
        int backspaceCount = 0;

        while (index >= 0) {
            char c = s.charAt(index);
            if (c == '#') {
                backspaceCount++;
                index--;
            } else {
                if (backspaceCount > 0) {
                    while (index >= 0 && backspaceCount > 0) {
                        char cTemp = s.charAt(index);

                        if (cTemp == '#') {
                            break;
                        }

                        backspaceCount--;
                        index--;
                    }
                } else break;
            }
        }

        return index;
    }
}
