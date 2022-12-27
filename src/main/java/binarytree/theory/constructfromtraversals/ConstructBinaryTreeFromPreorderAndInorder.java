package binarytree.theory.constructfromtraversals;

import helper.tree.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorder {
    private static final Map<Integer, Integer> inOrderMap = new HashMap<>();
    private static int preOrderIndex = 0;

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 7, 5, 3, 6, 8};
        int[] inOrder = new int[]{7, 4, 2, 5, 1, 3, 6, 8};

        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        TreeNode root = solution(preOrder, 0, inOrder.length - 1);
        root.print();
    }

    private static TreeNode solution(int[] preOrder, int left, int right) {
        if (left > right) return null;

        int rootVal = preOrder[preOrderIndex++];
        int rootIndex = inOrderMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);

        node.left = solution(preOrder, left, rootIndex - 1);
        node.right = solution(preOrder, rootIndex + 1, right);

        return node;
    }
}
