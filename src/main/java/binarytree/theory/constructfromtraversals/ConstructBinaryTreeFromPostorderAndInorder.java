package binarytree.theory.constructfromtraversals;

import helper.tree.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPostorderAndInorder {

    private static final Map<Integer, Integer> inOrderMap = new HashMap<>();
    private static int postOrderIndex = 0;

    public static void main(String[] args) {
        int[] postOrder = new int[]{7, 4, 5, 2, 8, 6, 3, 1};
        int[] inOrder = new int[]{7, 4, 2, 5, 1, 3, 6, 8};

        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        postOrderIndex = postOrder.length - 1;

        TreeNode root = solution(postOrder, 0, inOrder.length - 1);
        root.print();
    }

    private static TreeNode solution(int[] postOrder, int left, int right) {
        if (left > right) return null;

        int rootVal = postOrder[postOrderIndex--];
        int rootIndex = inOrderMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);

        node.right = solution(postOrder, rootIndex + 1, right);
        node.left = solution(postOrder, left, rootIndex - 1);

        return node;
    }
}
