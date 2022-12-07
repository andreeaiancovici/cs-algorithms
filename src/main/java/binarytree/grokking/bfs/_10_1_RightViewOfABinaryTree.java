package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, return an array containing nodes in its right view.
 * The right view of a binary tree is the set of nodes visible when the tree is seen from the right side.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _10_1_RightViewOfABinaryTree {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(1, 3, 7), solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));
        assertEquals(Arrays.asList(12, 1, 5, 3), solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5, null, null, 3))));
    }

    private static List<Integer> solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> rightNodesValues = new ArrayList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                if (i == n - 1) rightNodesValues.add(node.value);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return rightNodesValues;
    }
}
