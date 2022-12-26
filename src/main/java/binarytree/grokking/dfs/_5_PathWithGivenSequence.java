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
 * Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(log(n)) and O(n) for worst case complexity (when tree is not balanced)
 */
public class _5_PathWithGivenSequence {

    public static void main(String[] args) {
        int[] sequence1 = new int[]{1, 9, 9};
        assertTrue(recursiveSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, null, null, 2, 9)), sequence1, 0));
        assertTrue(iterativeSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, null, null, 2, 9)), sequence1));

        int[] sequence2 = new int[]{1, 0, 7};
        assertFalse(recursiveSolution(TreeBuilder.build(Arrays.asList(1, 0, 1, null, 1, 6, 5)), sequence2, 0));
        assertFalse(iterativeSolution(TreeBuilder.build(Arrays.asList(1, 0, 1, null, 1, 6, 5)), sequence2));

        int[] sequence3 = new int[]{1, 1, 6};
        assertTrue(recursiveSolution(TreeBuilder.build(Arrays.asList(1, 0, 1, null, 1, 6, 5)), sequence3, 0));
        assertTrue(iterativeSolution(TreeBuilder.build(Arrays.asList(1, 0, 1, null, 1, 6, 5)), sequence3));
    }

    private static boolean recursiveSolution(TreeNode node, int[] sequence, int index) {
        if (node == null) return index == sequence.length;

        if (node.value != sequence[index]) return false;

        return recursiveSolution(node.left, sequence, index + 1) || recursiveSolution(node.right, sequence, index + 1);
    }

    private static boolean iterativeSolution(TreeNode node, int[] sequence) {
        Deque<Pair<TreeNode, Pair<Boolean, Integer>>> stack = new ArrayDeque<>();
        boolean seen;
        int index;

        stack.push(new MutablePair<>(node, new MutablePair<>(false, 0)));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Pair<Boolean, Integer>> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue().getKey();
            index = pair.getValue().getValue();

            if (seen) {
                if (node.left == null && node.right == null && index == sequence.length - 1) return true;
            } else {
                stack.push(new MutablePair<>(node, new MutablePair<>(true, index)));

                if (node.value != sequence[index]) continue;

                if (node.right != null && node.right.value == sequence[index + 1])
                    stack.push(new MutablePair<>(node.right, new MutablePair<>(false, index + 1)));
                if (node.left != null && node.left.value == sequence[index + 1])
                    stack.push(new MutablePair<>(node.left, new MutablePair<>(false, index + 1)));
            }
        }

        return false;
    }
}
