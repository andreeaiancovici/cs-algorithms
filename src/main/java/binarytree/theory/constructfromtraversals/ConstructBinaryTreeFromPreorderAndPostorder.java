package binarytree.theory.constructfromtraversals;

import helper.tree.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndPostorder {

    private static final Map<Integer, Integer> postOrderMap = new HashMap<>();
    private static int preOrderIndex = 0;

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 4, 7, 5, 3, 6, 8};
        int[] postOrder = new int[]{7, 4, 5, 2, 8, 6, 3, 1};

        for (int i = 0; i < postOrder.length; i++) {
            postOrderMap.put(postOrder[i], i);
        }

        TreeNode root = solution(preOrder, 0, postOrder.length - 1);
        root.print();
    }

    private static TreeNode solution(int[] preOrder, int left, int right) {
        if (left > right) return null;

        int rootVal = preOrder[preOrderIndex++];
        int rootIndex = postOrderMap.get(rootVal);

        TreeNode node = new TreeNode(rootVal);

        if (preOrderIndex < preOrder.length) {
            int nextRootVal = preOrder[preOrderIndex];
            int nextRootIndex = postOrderMap.get(nextRootVal);

            node.left = solution(preOrder, left, rootIndex - 1);
            node.right = solution(preOrder, nextRootIndex + 1, rootIndex - 1);
        }

        return node;
    }
}
