package bitwise;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary matrix representing an image, we want to flip the image horizontally, then invert it.
 * ---
 * Solution:
 * Horizontally flip the matrix, by iterating each row until middle column.
 * Invert each element in the matrix by XOR-ing with 1.
 * ---
 * Time Complexity: O(m x n)
 * Space Complexity: O(1)
 */
public class FlipMatrix {

    public static void main(String[] args) {

        assertEquals(Arrays.asList(Arrays.asList(0, 1, 0),
                Arrays.asList(0, 0, 0),
                Arrays.asList(0, 0, 1)),
                flipMatrix(Arrays.asList(Arrays.asList(1, 0, 1),
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(0, 1, 1))));

        assertEquals(Arrays.asList(Arrays.asList(1, 1, 0, 0),
                Arrays.asList(0, 1, 1, 0),
                Arrays.asList(0, 0, 0, 1),
                Arrays.asList(1, 0, 1, 0)),
                flipMatrix(Arrays.asList(Arrays.asList(1, 1, 0, 0),
                        Arrays.asList(1, 0, 0, 1),
                        Arrays.asList(0, 1, 1, 1),
                        Arrays.asList(1, 0, 1, 0))));
    }

    private static List<List<Integer>> flipMatrix(List<List<Integer>> matrix) {
        int noColumns = matrix.get(0).size();

        for (List<Integer> rows : matrix) {
            for (int j = 0; j < noColumns / 2; j++) {
                int temp = rows.get(j);
                rows.set(j, rows.get(noColumns - 1 - j));
                rows.set(noColumns - 1 - j, temp);
            }
        }

        for (List<Integer> rows : matrix) {
            for (int j = 0; j < noColumns; j++) {
                rows.set(j, rows.get(j) ^ 1);
            }
        }

        return matrix;
    }
}
