package arrays.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given an array of characters where each character represents a fruit tree,
 * you are given two baskets and your goal is to put maximum number of fruits in each basket.
 * The only restriction is that each basket can have only one type of fruit.
 * You can start with any tree, but once you have started you can’t skip a tree.
 * You will pick one fruit from each tree until you cannot, i.e.,
 * you will stop when you have to pick from a third fruit type.
 * Write a function to return the maximum number of fruits in both the baskets.
 * ---
 * Solution:
 * Sliding Window
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(k), where k = distinct fruits
 */
public class FruitsIntoBaskets {

    public static void main(String[] args) {
        assertEquals(3, fruitsIntoBaskets(Arrays.asList('A', 'B', 'C', 'A', 'C')));
        assertEquals(5, fruitsIntoBaskets(Arrays.asList('A', 'B', 'C', 'B', 'B', 'C')));
    }

    private static int fruitsIntoBaskets(List<Character> fruits) {
        Map<Character, Integer> fruitFrequencies = new HashMap<>();
        int windowStart = 0, maxLength = 0;

        for (int windowEnd = 0; windowEnd < fruits.size(); windowEnd++) {
            fruitFrequencies.merge(fruits.get(windowEnd), 1, Integer::sum);

            while (fruitFrequencies.size() > 2) {
                fruitFrequencies.merge(fruits.get(windowStart), 1, (prev, value) -> prev - value);

                if (fruitFrequencies.get(fruits.get(windowStart)) <= 0) {
                    fruitFrequencies.remove(fruits.get(windowStart));
                }

                windowStart++;
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart);
        }

        return maxLength + 1;
    }
}
