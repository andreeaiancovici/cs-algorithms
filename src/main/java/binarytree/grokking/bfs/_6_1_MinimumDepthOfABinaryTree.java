package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Find the minimum depth of a binary tree. The minimum depth is the number of nodes along
 * the shortest path from the root node to the nearest leaf node.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _6_1_MinimumDepthOfABinaryTree {

    public static void main(String[] args) {
        assertEquals(2, solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5))));
        assertEquals(2, solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, null, 10, 5))));
        assertEquals(3, solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5, null, null, null, null, 11))));
    }

    private static int solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int minDepth = Integer.MAX_VALUE;
        int depth = 1;

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            int max = 0;

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                max = Math.max(max, node.value);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                if (node.left == null && node.right == null) minDepth = Math.min(minDepth, depth);
            }

            depth++;
        }

        return minDepth;
    }
}
