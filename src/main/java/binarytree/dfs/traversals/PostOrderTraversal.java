package binarytree.dfs.traversals;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.Arrays;

/**
 * Root is always traversed after children nodes.
 * Variants:
 * - Left -> Right -> Root
 * - Right -> Left -> Root
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        dfsPostOrder(root);
    }

    private static void dfsPostOrder(TreeNode node) {
        if (node == null) return;

        dfsPostOrder(node.left);
        dfsPostOrder(node.right);

        System.out.print(node.value + " ");
    }
}
