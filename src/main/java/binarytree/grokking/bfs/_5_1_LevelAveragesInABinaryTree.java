package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, populate an array to represent the averages of all of its levels.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _5_1_LevelAveragesInABinaryTree {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1.0, 2.5, 5.5), solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
        assertEquals(Arrays.asList(12.0, 4.0, 6.5), solution(TreeBuilder.build(Arrays.asList(12, 7, 1, 9, 2, 10, 5))));
    }

    private static List<Double> solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Double> averages = new ArrayList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0;

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                sum += node.value;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            averages.add(sum / n);
        }

        return averages;
    }
}
