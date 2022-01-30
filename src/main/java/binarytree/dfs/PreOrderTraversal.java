package binarytree.dfs;

import binarytree.TreeBuilder;
import binarytree.TreeNode;

import java.util.Arrays;

/**
 * Root -> Left -> Right
 */
public class PreOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        preOrder(root);
    }

    private static void preOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        System.out.print(root.getValue() + " ");

        preOrder(root.getLeft());
        preOrder(root.getRight());
    }
}