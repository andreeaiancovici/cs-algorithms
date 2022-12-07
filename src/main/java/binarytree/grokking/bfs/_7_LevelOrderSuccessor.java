package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given a binary tree and a node, find the level order successor of the given node in the tree.
 * The level order successor is the node that appears right after the given node in the level order traversal.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _7_LevelOrderSuccessor {

    public static void main(String[] args) {
        assertEquals(4, solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5)), 3));
        assertEquals(10, solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5)), 9));
        assertEquals(7, solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5)), 12));
    }

    private static int solution(TreeNode node, int target) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode targetNode = null;

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                if (targetNode != null) return node.value;

                if (node.value == target) targetNode = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }

        return -1;
    }
}
