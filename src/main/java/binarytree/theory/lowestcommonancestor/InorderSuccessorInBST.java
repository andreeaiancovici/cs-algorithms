package binarytree.theory.lowestcommonancestor;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class InorderSuccessorInBST {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(2, 1, 3));
        assertEquals(root.getNode(2), solution(root, root.getNode(1)));
    }

    private static TreeNode solution(TreeNode node, TreeNode p) {
        TreeNode successor = null;

        while (node != null) {
            if (p.value < node.value) {
                successor = node;
                node = node.left;
            } else node = node.right;
        }

        return successor;
    }
}
