package binarytree.theory.traversals.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Root is always traversed in the middle of the 2 children.
 * Binary Search Tree -> In this case, in order traversal generates a sorted array.
 * Variants:
 * - Left -> Root -> Right
 * - Right -> Root -> Left
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n) / O(log(n)), depending if tree is skewed
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        TreeNode bstRoot = TreeBuilder.build(Arrays.asList(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null));
        dfsInOrderRecursive(root);
        System.out.println();
        dfsInOrderIterative(root);
        System.out.println();
        dfsInOrderMorris(root);

        System.out.println();
        dfsInOrderRecursive(bstRoot);
        System.out.println();
        dfsInOrderIterative(bstRoot);
        System.out.println();
        dfsInOrderMorris(bstRoot);
    }

    private static void dfsInOrderRecursive(TreeNode node) {
        if (node == null) return;

        dfsInOrderRecursive(node.left);
        System.out.print(node.value + " ");
        dfsInOrderRecursive(node.right);
    }

    private static void dfsInOrderIterative(TreeNode node) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            node = stack.pop();
            System.out.print(node.value + " ");
            node = node.right;
        }
    }

    // Improves space from O(n) to O(1)
    private static void dfsInOrderMorris(TreeNode node) {
        while (node != null) {
            if (node.left == null) {
                System.out.print(node.value + " ");
                node = node.right;
            } else {
                TreeNode leftNode = node.left;
                while (leftNode.right != null) leftNode = leftNode.right;
                leftNode.right = node;

                leftNode = node.left;
                node.left = null;
                node = leftNode;
            }
        }
    }
}
