package binarytree.theory.traversals.dfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Root is always traversed after children nodes.
 * Variants:
 * - Left -> Right -> Root
 * - Right -> Left -> Root
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(n) / O(log(n)), depending if tree is skewed
 */
public class PostOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        dfsPostOrderRecursive(root);
        System.out.println();
        dfsPostOrderIterative(root);
    }

    private static void dfsPostOrderRecursive(TreeNode node) {
        if (node == null) return;

        dfsPostOrderRecursive(node.left);
        dfsPostOrderRecursive(node.right);
        System.out.print(node.value + " ");
    }

    private static void dfsPostOrderIterative(TreeNode node) {
        Deque<Pair<TreeNode, Boolean>> stack = new ArrayDeque<>();

        stack.push(new MutablePair<>(node, false));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Boolean> pair = stack.pop();
            node = pair.getKey();
            boolean seen = pair.getValue();

            if (seen) {
                System.out.print(node.value + " ");
            } else {
                stack.push(new MutablePair<>(node, true));

                if (node.right != null) stack.push(new MutablePair<>(node.right, false));
                if (node.left != null) stack.push(new MutablePair<>(node.left, false));
            }
        }
    }
}
