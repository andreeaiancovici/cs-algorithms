package binarytree.bfs;

import binarytree.TreeBuilder;
import binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class BFSTraversal {

    public static void main(String[] args) {
        TreeNode root = TreeBuilder.build(Arrays.asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, 8));
        bfs(root);
    }

    private static void bfs(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        while(!queue.isEmpty()) {

        }
    }
}
