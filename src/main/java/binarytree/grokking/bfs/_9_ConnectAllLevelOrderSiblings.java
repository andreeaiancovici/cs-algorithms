package binarytree.grokking.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Question:
 * Given a binary tree, connect each node with its level order successor.
 * The last node of each level should point to the first node of the next level.
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _9_ConnectAllLevelOrderSiblings {

    public static void main(String[] args) {
        print(solution(TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, 6, 7))));

        System.out.println();

        print(solution(TreeBuilder.build(Arrays.asList(12, 7, 1, null, 9, 10, 5))));
    }

    private static void print(TreeNode node) {
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }

    private static TreeNode solution(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = node;
        TreeNode prev = null;

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

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
