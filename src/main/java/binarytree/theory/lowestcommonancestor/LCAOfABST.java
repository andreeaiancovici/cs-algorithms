package binarytree.theory.lowestcommonancestor;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.junit.Assert.assertEquals;

public class LCAOfABST {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(6, 2, 8, 0, 4, 7, 9, null, null, 3, 5));
        assertEquals(root.getNode(6), solution(root, root.getNode(2), root.getNode(8)));
    }

    private static TreeNode solution(TreeNode node, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();

        stack.push(node);

        while (!stack.isEmpty()) {
            node = stack.pop();

            if (node.left != null && p.value < node.value && q.value < node.value) stack.push(node.left);
            if (node.right != null && node.value < p.value && node.value < q.value) stack.push(node.right);
        }

        return node;
    }
}
