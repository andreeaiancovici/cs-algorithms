package binarytree.theory.serialization;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class TreeSerialization {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        assertEquals("1-2--4---7#--5#-3--6---8#", serialize(root, 0, new StringBuilder()).toString());
    }

    private static StringBuilder serialize(TreeNode node, int level, StringBuilder sb) {
        if (node == null) {
            sb.append("#");
        } else {
            for (int i = 0; i < level; i++) sb.append("-");
            sb.append(node.value);

            if (node.left == null && node.right == null) sb.append("#");

            if (node.left != null) serialize(node.left, level + 1, sb);
            if (node.right != null) serialize(node.right, level + 1, sb);
        }

        return sb;
    }
}
