package binarytree.dfs.traversals;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.Arrays;

/**
 * Root is always traversed in the middle of the 2 children.
 * Binary Search Tree -> In this case, in order traversal generates a sorted array.
 * Variants:
 * - Left -> Root -> Right
 * - Right -> Root -> Left
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        TreeNode bstRoot = TreeBuilder.build(Arrays.asList(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null));
        dfsInOrder(root);

        System.out.println();
        dfsInOrder(bstRoot);
    }

    private static void dfsInOrder(TreeNode node) {
        if (node == null) return;

        dfsInOrder(node.left);

        System.out.print(node.value + " ");

        dfsInOrder(node.right);
    }
}
