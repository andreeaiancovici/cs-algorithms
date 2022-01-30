package binarytree.dfs;

import binarytree.TreeBuilder;
import binarytree.TreeNode;

import java.util.Arrays;

/**
 * Left -> Root -> Right
 * Binary Search Tree:
 * In this case, in order traversal generates a sorted array.
 */
public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        TreeNode bstRoot = TreeBuilder.build(Arrays.asList(8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13, null));
        inOrder(root);

        System.out.println();
        inOrder(bstRoot);
    }

    private static void inOrder(TreeNode root) {
        if(root == null) {
            return;
        }

        inOrder(root.getLeft());

        System.out.print(root.getValue() + " ");

        inOrder(root.getRight());
    }
}
