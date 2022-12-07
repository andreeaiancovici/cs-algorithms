package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree, populate an array to represent its zigzag level order traversal.
 * You should populate the values of all nodes of the first level from left to right,
 * then right to left for the next level and keep alternating in the same manner for the following levels.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _4_ZigzagTraversal {

    public static void main(String[] args) {
        assertEquals(Arrays.asList(
                Collections.singletonList(1),
                Arrays.asList(3, 2),
                Arrays.asList(4, 5, 6, 7)),
                solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));

        assertEquals(Arrays.asList(
                Collections.singletonList(12),
                Arrays.asList(1, 7),
                Arrays.asList(9, 10, 5),
                Arrays.asList(17, 20)),
                solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5, null, null, null, null, 20, 17))));
    }

    private static List<List<Integer>> solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> levels = new ArrayList<>();
        int isLeftToRight = 1;

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if (isLeftToRight == 1) node = queue.poll();
                else node = queue.pollLast();

                level.add(node.value);

                if (isLeftToRight == 1) {
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                } else {
                    if (node.right != null) queue.addFirst(node.right);
                    if (node.left != null) queue.addFirst(node.left);
                }
            }

            isLeftToRight ^= 1;

            levels.add(level);
        }

        return levels;
    }
}
