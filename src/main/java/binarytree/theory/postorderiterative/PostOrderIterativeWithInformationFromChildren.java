package binarytree.theory.postorderiterative;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

import static org.junit.Assert.assertEquals;

/**
 * Question:
 * Given the root of a binary tree, return the number of nodes where the value of the node is equal to the sum of the values of its descendants.
 * A descendant of a node x is any node that is on the path from node x to some leaf node. The sum is considered to be 0 if the node has no descendants.
 */
public class PostOrderIterativeWithInformationFromChildren {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 7, 5, null, 6, 7, null, null, null, null, 8));
        assertEquals(1, solution(root));
    }

    private static int solution(TreeNode node) {
        int count = 0;
        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();
        Map<TreeNode, Integer> nodeToSumMap = new HashMap<>();
        boolean seen;

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            seen = pair.getValue();

            if (seen) {
                int leftSum = 0, rightSum = 0;
                if (node.left != null) leftSum = nodeToSumMap.get(node.left);
                if (node.right != null) rightSum = nodeToSumMap.get(node.right);

                if (node.value == leftSum + rightSum) count++;

                nodeToSumMap.put(node, node.value + leftSum + rightSum);
            } else {
                stack.push(new MutablePair<>(node, true));

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }

        return count;
    }
}
