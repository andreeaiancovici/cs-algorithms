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
 * Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
 * Find the total sum of all the numbers represented by all paths.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(log(n)) and O(n) for worst case complexity (when tree is not balanced)
 */
public class _4_SumOfPathNumbers {

    public static void main(String[] args) {
        assertEquals(408, recursiveSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, null, null, 2, 9)), 0));
        assertEquals(408, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, null, null, 2, 9))));

        assertEquals(332, recursiveSolution(TreeBuilder.build(Arrays.asList(1, 0, 1, null, 1, 6, 5)), 0));
        assertEquals(332, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 0, 1, null, 1, 6, 5))));
    }

    private static int recursiveSolution(TreeNode node, int num) {
        if (node == null) return 0;

        num = num * 10 + node.value;

        if (node.left == null && node.right == null) return num;

        return recursiveSolution(node.left, num) + recursiveSolution(node.right, num);
    }

    private static int iterativeSolution(TreeNode node) {
        int sum = 0;

        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
        boolean seen;
        int num = 0;

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue();

            if (seen) num /= 10;
            else {
                stack.push(new MutablePair<>(node, true));

                num = num * 10 + node.value;

                if (node.left == null && node.right == null) sum += num;

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return sum;
    }
}
