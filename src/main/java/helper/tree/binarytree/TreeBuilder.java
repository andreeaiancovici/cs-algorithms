package helper.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class TreeBuilder {

    public static TreeNode build(List<Integer> nodes) {
        Deque<TreeNode> queue = new ArrayDeque<>();

        TreeNode root = new TreeNode(nodes.get(0));
        TreeNode node = root;

        queue.add(node);

        int index = 1;
        while (!queue.isEmpty() && index < nodes.size()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                node = queue.poll();

                if (index < nodes.size()) {
                    if (nodes.get(index) == null) index++;
                    else {
                        node.left = new TreeNode(nodes.get(index++));
                        queue.add(node.left);
                    }
                }
                if (index < nodes.size()) {
                    if (nodes.get(index) == null) index++;
                    else {
                        node.right = new TreeNode(nodes.get(index++));
                        queue.add(node.right);
                    }
                }
            }
        }

        return root;
    }
}
