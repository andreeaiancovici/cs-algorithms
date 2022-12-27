package binarytree.theory.constructfromtraversals;

import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstructBSTFromPreorderTraversal {

    public static void main(String[] args) {
        int[] preOrder = new int[]{8, 5, 1, 7, 10, 12};

        TreeNode root = solution(preOrder);
        root.print();
    }

    private static TreeNode solution(int[] preOrder) {
        Deque<TreeNode> monostack = new ArrayDeque<>();

        TreeNode root = new TreeNode(preOrder[0]);

        TreeNode node = root;
        monostack.push(node);

        for (int i = 1; i < preOrder.length; i++) {
            TreeNode newNode = new TreeNode(preOrder[i]);

            if (preOrder[i] < monostack.peek().value) monostack.peek().left = newNode;
            else {
                while (!monostack.isEmpty() && monostack.peek().value < preOrder[i]) node = monostack.pop();
                node.right = newNode;
            }

            monostack.push(newNode);
        }

        return root;
    }
}
