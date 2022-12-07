package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Question:
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to a null node.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _8_ConnectLevelOrderSiblings {

    public static void main(String[] args) {
        print(solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));

        System.out.println();

        print(solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5))));
    }

    private static void print(TreeNode node) {
        TreeNode firstNonNullNode = null;

        while (node != null) {
            while (node != null) {
                System.out.print(node.value + " ");

                if (node.left != null && firstNonNullNode == null) firstNonNullNode = node.left;
                if (node.right != null && firstNonNullNode == null) firstNonNullNode = node.right;

                node = node.next;
            }

            System.out.println();
            node = firstNonNullNode;
            firstNonNullNode = null;
        }
    }

    private static TreeNode solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = node;

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            TreeNode prev = null;
            for (int i = 0; i < n; i++) {
                node = queue.poll();

                if (prev != null) prev.next = node;

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                prev = node;
            }
        }

        return root;
    }
}
