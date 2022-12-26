package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.
 * A path can be defined as a sequence of nodes between any two nodes and doesn't necessarily pass through the root.
 * Node: Solution includes Kadane's algorithm.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(log(n)) and O(n) for worst case complexity (when tree is not balanced)
 */
public class _8_PathWithMaximumSum {

    public static void main(String[] args) {
        int[] maxSum1 = new int[1];
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, null, 4, 5, 6)), maxSum1);
        assertEquals(16, maxSum1[0]);

        assertEquals(16, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, null, 4, 5, 6))));


        int[] maxSum2 = new int[1];
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, 1, 3, 5, 6, null, null, null, null, 7, 8, null, 9)), maxSum2);
        assertEquals(31, maxSum2[0]);

        assertEquals(31, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, 1, 3, 5, 6, null, null, null, null, 7, 8, null, 9))));
    }

    private static int recursiveSolution(TreeNode node, int[] maxSum) {
        if (node == null) return 0;

        int left = recursiveSolution(node.left, maxSum);
        int right = recursiveSolution(node.right, maxSum);

        maxSum[0] = Math.max(maxSum[0], left + node.value + right);

        int sum = Math.max(left, right);

        return sum < sum + node.value ? sum + node.value : node.value;
    }

    private static int iterativeSolution(TreeNode node) {
        int maxSum = 0;
        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        boolean seen;

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue();

            if (seen) {
                int left = 0, right = 0;
                if (node.left != null) left = map.get(node.left);
                if (node.right != null) right = map.get(node.right);

                maxSum = Math.max(maxSum, left + node.value + right);

                int sum = Math.max(left, right);

                map.put(node, sum < sum + node.value ? sum + node.value : node.value);
            } else {
                stack.push(new MutablePair<>(node, true));

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return maxSum;
    }
}
