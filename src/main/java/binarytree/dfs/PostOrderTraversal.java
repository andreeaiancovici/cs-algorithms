package binarytree.dfs;

import binarytree.TreeBuilder;
import binarytree.TreeNode;

import java.util.Arrays;

/**
 * Left -> Right -> Root
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        postOrder(root);
    }

    private static void postOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        postOrder(root.getLeft());
        postOrder(root.getRight());

        System.out.print(root.getValue() + " ");
    }
}