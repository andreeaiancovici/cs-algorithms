package binarytree.theory.traversals.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Root is always traversed before children nodes.
 * Variants:
 * - Root -> Left -> Right
 * - Root -> Right -> Left
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n) / O(log(n)), depending if tree is skewed
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        dfsPreOrderRecursive(root);
        System.out.println();
        dfsPreOrderIterative(root);
    }

    private static void dfsPreOrderRecursive(TreeNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");
        dfsPreOrderRecursive(node.left);
        dfsPreOrderRecursive(node.right);
    }

    private static void dfsPreOrderIterative(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            System.out.print(node.value + " ");

            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
        }
    }
}
