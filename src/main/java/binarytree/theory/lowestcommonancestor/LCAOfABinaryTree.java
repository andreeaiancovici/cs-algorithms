package binarytree.theory.lowestcommonancestor;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class LCAOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        assertEquals(root.getNode(3), recursiveSolution(root, root.getNode(5), root.getNode(1)));
        assertEquals(root.getNode(3), iterativeSolution(root, root.getNode(5), root.getNode(1)));
    }

    private static TreeNode recursiveSolution(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return null;

        TreeNode leftNode = recursiveSolution(node.left, p, q);
        TreeNode rightNode = recursiveSolution(node.right, p, q);

        if (leftNode != null && rightNode != null) return node;

        if (node == p || node == q) return node;

        return leftNode == null ? rightNode : leftNode;
    }

    private static TreeNode iterativeSolution(TreeNode node, TreeNode p, TreeNode q) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        Map<TreeNode, TreeNode> ancestors = new HashMap<>();

        stack.push(node);
        ancestors.put(node, null);

        while (!ancestors.containsKey(p) || !ancestors.containsKey(q)) {
            node = stack.pop();

            if (node.right != null) {
                stack.push(node.right);
                ancestors.put(node.right, node);
            }

            if (node.left != null) {
                stack.push(node.left);
                ancestors.put(node.left, node);
            }
        }

        Set<TreeNode> pAncestors = new HashSet<>();

        while (p != null) {
            pAncestors.add(p);
            p = ancestors.get(p);
        }

        while (!pAncestors.contains(q)) {
            q = ancestors.get(q);
        }

        return q;
    }
}
