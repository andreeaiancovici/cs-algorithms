package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes on the longest path
 * between any two leaf nodes. The diameter of a tree may or may not pass through the root.
 * Note: You can always assume that there are at least two leaf nodes in the given tree.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(log(n)) and O(n) for worst case complexity (when tree is not balanced)
 */
public class _7_TreeDiameter {

    public static void main(String[] args) {
        int[] diameter1 = new int[1];
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, null, 4, 5, 6)), diameter1);
        assertEquals(5, diameter1[0]);

        assertEquals(5, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, null, 4, 5, 6))));


        int[] diameter2 = new int[1];
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, null, null, 5, 6, 7, 8, null, 9, null, null, null, 10, null, 11)), diameter2);
        assertEquals(7, diameter2[0]);

        assertEquals(7, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 2, 3, null, null, 5, 6, 7, 8, null, 9, null, null, null, 10, null, 11))));
    }

    private static int recursiveSolution(TreeNode node, int[] diameter) {
        if (node == null) return 0;

        int left = recursiveSolution(node.left, diameter);
        int right = recursiveSolution(node.right, diameter);

        if (left != 0 && right != 0) diameter[0] = Math.max(diameter[0], left + 1 + right);

        return Math.max(left, right) + 1;
    }

    private static int iterativeSolution(TreeNode node) {
        int diameter = 0;
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

                if (left != 0 && right != 0) diameter = Math.max(diameter, left + 1 + right);

                map.put(node, Math.max(left, right) + 1);
            } else {
                stack.push(new MutablePair<>(node, true));

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return diameter;
    }
}
