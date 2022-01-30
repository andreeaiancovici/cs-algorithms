package binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TreeBuilder {

    public static TreeNode build(List<Integer> nodes) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(nodes.get(0));
        queue.addFirst(root);

        int index = 1;
        int level = 1;
        while(!queue.isEmpty() && index < nodes.size()) {
            int levelLimit = index + 2 * level;

            while (!queue.isEmpty() && index < levelLimit) {
                TreeNode node = queue.pollLast();

                if(nodes.get(index) != null) {
                    node.setLeft(new TreeNode(nodes.get(index)));
                    queue.addFirst(node.getLeft());
                }

                index++;

                if(nodes.get(index) != null) {
                    node.setRight(new TreeNode(nodes.get(index)));
                    queue.addFirst(node.getRight());
                }

                index++;
            }
            level++;
        }

        return root;
    }
}
