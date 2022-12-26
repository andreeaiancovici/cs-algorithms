package binarytree.grokking.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree and a number ‘S’, find all paths in the tree such that the sum of all the node values
 * of each path equals ‘S’. Please note that the paths can start or end at any node but all paths must follow
 * direction from parent to child (top to bottom).
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(log(n)) and O(n) for worst case complexity (when tree is not balanced)
 */
public class _6_CountPathsForASum {
    private static final Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        initMap();
        assertEquals(3, recursiveSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 6, 5, 2, 3)), 0, 12));

        initMap();
        assertEquals(3, iterativeSolution(TreeBuilder.build(Arrays.asList(1, 7, 9, 6, 5, 2, 3)), 12));


        initMap();
        assertEquals(2, recursiveSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)), 0, 11));

        initMap();
        assertEquals(2, iterativeSolution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 4, 10, 5)), 11));
    }

    private static void initMap() {
        map.clear();
        map.put(0, 1);
    }

    private static int recursiveSolution(TreeNode node, int sum, int S) {
        if (node == null) return 0;

        sum += node.value;

        int count = 0;

        if (map.containsKey(sum - S)) count += map.get(sum - S);

        map.put(sum, map.getOrDefault(sum, 0) + 1);

        count += recursiveSolution(node.left, sum, S);
        count += recursiveSolution(node.right, sum, S);

        if (map.get(sum) == 1) map.remove(sum);
        else map.put(sum, map.get(sum) - 1);

        return count;
    }

    private static int iterativeSolution(TreeNode node, int S) {
        int count = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        int sum;

        stack.push(new MutablePair<>(node, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> pair = stack.pop();
            node = pair.getKey();
            sum = pair.getValue();

            sum += node.value;

            if (map.containsKey(sum - S)) count += map.get(sum - S);

            map.put(sum, map.getOrDefault(sum, 0) + 1);

            if (node.right != null) stack.push(new MutablePair<>(node.right, sum));
            if (node.left != null) stack.push(new MutablePair<>(node.left, sum));
        }

        return count;
    }
}
