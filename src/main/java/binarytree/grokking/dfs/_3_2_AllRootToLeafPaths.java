package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, return all root-to-leaf paths.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n * log(n)) and O(n^2) for worst case complexity (when tree is not balanced)
 * Note: Storing each path takes O(n)
 */
public class _3_2_AllRootToLeafPaths {

    public static void main(String[] args) {
        List<List<Integer>> result1 = Arrays.asList(
                Arrays.asList(1, 7, 4),
                Arrays.asList(1, 7, 5),
                Arrays.asList(1, 9, 2),
                Arrays.asList(1, 9, 7));

        List<List<Integer>> list1Recursive = new ArrayList<>();
        recursiveSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 4, 5, 2, 7)), new ArrayList<>(), list1Recursive);
        assertEquals(result1, list1Recursive);

        List<List<Integer>> list1Iterative = iterativeSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 4, 5, 2, 7)));
        assertEquals(result1, list1Iterative);

        List<List<Integer>> result2 = Arrays.asList(
                Arrays.asList(12, 7, 4),
                Arrays.asList(12, 1, 10),
                Arrays.asList(12, 1, 5));

        List<List<Integer>> list2Recursive = new ArrayList<>();
        recursiveSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)), new ArrayList<>(), list2Recursive);
        assertEquals(result2, list2Recursive);

        List<List<Integer>> list2Iterative = iterativeSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)));
        assertEquals(result2, list2Iterative);
    }

    private static void recursiveSolution(TreeNode node, List<Integer> path, List<List<Integer>> list) {
        if (node == null) return;

        path.add(node.value);

        if (node.left == null && node.right == null) list.add(new ArrayList<>(path));

        recursiveSolution(node.left, path, list);
        recursiveSolution(node.right, path, list);

        path.remove(path.size() - 1);
    }

    private static List<List<Integer>> iterativeSolution(TreeNode node) {
        List<List<Integer>> list = new ArrayList<>();

        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        boolean seen;

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue();

            if (seen) {
                path.remove(path.size() - 1);
            } else {
                stack.push(new MutablePair<>(node, true));

                path.add(node.value);

                if (node.left == null && node.right == null) list.add(new ArrayList<>(path));

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return list;
    }
}
