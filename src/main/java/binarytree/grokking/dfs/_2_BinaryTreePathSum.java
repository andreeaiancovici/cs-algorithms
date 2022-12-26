package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Question:
 * Given a binary tree and a number ‘S’, find if the tree has a path from root-to-leaf
 * such that the sum of all the node values of that path equals ‘S’.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _2_BinaryTreePathSum {

    public static void main(String[] args) {
        assertTrue(recursiveSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 10));
        assertTrue(iterativeSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 10));

        assertTrue(recursiveSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5)), 23));
        assertTrue(iterativeSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5)), 23));

        assertFalse(recursiveSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5)), 16));
        assertFalse(iterativeSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5)), 16));
    }

    private static boolean recursiveSolution(TreeNode node, int targetSum) {
        if (node == null) return false;

        targetSum -= node.value;

        if (node.left == null && node.right == null && targetSum == 0) return true;

        return recursiveSolution(node.left, targetSum) || recursiveSolution(node.right, targetSum);
    }

    private static boolean iterativeSolution(TreeNode node, int targetSum) {
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        int sum;

        stack.push(new MutablePair<>(node, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            node = pair.getKey();
            sum = pair.getValue();

            sum += node.value;

            if (node.left == null && node.right == null && sum == targetSum) return true;

            if (node.left != null) stack.push(new MutablePair<>(node.left, sum));
            if (node.right != null) stack.push(new MutablePair<>(node.right, sum));
        }

        return false;
    }
}
