package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Find the largest value on each level of a binary tree.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _5_2_LevelMaximumInABinaryTree {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 3, 7), solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
        assertEquals(Arrays.asList(12, 7, 10), solution(TreeBuilder.build(Arrays.asList(12, 7, 1, 9, 2, 10, 5))));
    }

    private static List<Integer> solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> maxValues = new ArrayList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = 0;

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                max = Math.max(max, node.value);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            maxValues.add(max);
        }

        return maxValues;
    }
}
