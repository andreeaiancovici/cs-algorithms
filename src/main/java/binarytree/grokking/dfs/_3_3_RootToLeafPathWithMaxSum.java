package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, find the root-to-leaf path with the maximum sum.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(log(n))
 */
public class _3_3_RootToLeafPathWithMaxSum {

    private static int maxSum;

    public static void main(String[] args) {
        maxSum = 0;
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 4, 5, 2, 7)), 0);
        assertEquals(17, maxSum);

        assertEquals(17, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 4, 5, 2, 7))));

        maxSum = 0;
        recursiveSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)), 0);
        assertEquals(23, maxSum);

        assertEquals(23, iterativeSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5))));
    }

    private static void recursiveSolution(TreeNode node, int sum) {
        if (node == null) return;

        sum += node.value;

        if (node.left == null && node.right == null) {
            maxSum = Math.max(maxSum, sum);
        }

        recursiveSolution(node.left, sum);
        recursiveSolution(node.right, sum);
    }

    private static int iterativeSolution(TreeNode node) {
        int maxSum = 0;

        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
        boolean seen;
        int sum = 0;

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue();

            if (seen) {
                sum -= node.value;
            } else {
                stack.push(new MutablePair<>(node, true));

                sum += node.value;

                if (node.left == null && node.right == null) maxSum = Math.max(maxSum, sum);

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return maxSum;
    }
}
