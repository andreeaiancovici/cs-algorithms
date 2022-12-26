package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the
 * sum of all the node values of each path equals ‘S’.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n * log(n)) and O(n^2) for worst case complexity (when tree is not balanced)
 * Note: Storing each path takes O(n)
 */
public class _3_1_AllPathsForASum {

    public static void main(String[] args) {
        List<List<Integer>> result1 = Arrays.asList(
                Arrays.asList(1, 7, 4),
                Arrays.asList(1, 9, 2));

        List<List<Integer>> list1Recursive = new ArrayList<>();
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 4, 5, 2, 7)), 12, new ArrayList<>(), list1Recursive);
        assertEquals(result1, list1Recursive);

        List<List<Integer>> list1Iterative = iterativeSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 4, 5, 2, 7)), 12);
        assertEquals(result1, list1Iterative);

        List<List<Integer>> result2 = Arrays.asList(
                Arrays.asList(12, 7, 4),
                Arrays.asList(12, 1, 10));

        List<List<Integer>> list2Recursive = new ArrayList<>();
        recursiveSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)), 23, new ArrayList<>(), list2Recursive);
        assertEquals(result2, list2Recursive);

        List<List<Integer>> list2Iterative = iterativeSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)), 23);
        assertEquals(result2, list2Iterative);
    }

    private static void recursiveSolution(TreeNode node, int targetSum, List<Integer> path, List<List<Integer>> list) {
        if (node == null) return;

        targetSum -= node.value;
        path.add(node.value);

        if (node.left == null && node.right == null && targetSum == 0) list.add(new ArrayList<>(path));

        recursiveSolution(node.left, targetSum, path, list);
        recursiveSolution(node.right, targetSum, path, list);

        path.remove(path.size() - 1);
    }

    private static List<List<Integer>> iterativeSolution(TreeNode node, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();

        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        boolean seen;
        int sum = 0;

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue();

            if (seen) {
                path.remove(path.size() - 1);
                sum -= node.value;
            } else {
                stack.push(new MutablePair<>(node, true));

                path.add(node.value);
                sum += node.value;

                if (node.left == null && node.right == null && sum == targetSum) list.add(new ArrayList<>(path));

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return list;
    }
}
