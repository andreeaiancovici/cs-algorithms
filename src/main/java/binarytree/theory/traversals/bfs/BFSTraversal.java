package binarytree.theory.traversals.bfs;

import helper.tree.binarytree.TreeBuilder;
import helper.tree.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Level order traversal
 * ---
 * Time Complexity: O(n)
 * Space Complexity: O(m), where m is the maximum size of a level
 */
public class BFSTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        bfs(root);
    }

    private static void bfs(TreeNode node) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        queue.add(node);

        while (!queue.isEmpty()) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                node = queue.poll();

                System.out.print(node.value + " ");

                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            System.out.println();
        }
    }
}
