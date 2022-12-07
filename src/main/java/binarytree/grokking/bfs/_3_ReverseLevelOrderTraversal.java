package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, populate an array to represent its level-by-level traversal in reverse order,
 * i.e., the lowest level comes first. You should populate the values of all nodes in each level from
 * left to right in separate sub-arrays.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _3_ReverseLevelOrderTraversal {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Arrays.asList(4, 5, 6, 7),
                Arrays.asList(2, 3),
                Collections.singletonList(1)),
                solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));

        assertEquals(Arrays.asList(
                Arrays.asList(9, 10, 5),
                Arrays.asList(7, 1),
                Collections.singletonList(12)),
                solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5))));
    }

    private static List<List<Integer>> solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> reversedLevels = new ArrayList<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                level.add(node.value);

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            reversedLevels.add(level);
        }

        Collections.reverse(reversedLevels);

        return reversedLevels;
    }
}
