package binarytree.dfs.traversals;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.Arrays;

/**
 * Root is always traversed before children nodes.
 * Variants:
 * - Root -> Left -> Right
 * - Root -> Right -> Left
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        dfsPreOrder(root);
    }

    private static void dfsPreOrder(TreeNode node) {
        if (node == null) return;

        System.out.print(node.value + " ");

        dfsPreOrder(node.left);
        dfsPreOrder(node.right);
    }
}
