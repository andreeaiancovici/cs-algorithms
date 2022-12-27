package helper.tree.binarytree;

public class TreeNode {

    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public int value;

    public TreeNode(int value) {
        this.value = value;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        traversePreOrder(sb, "", "", this);
        System.out.println(sb);
    }

    public void traversePreOrder(StringBuilder sb, String padding, String pointer, TreeNode node) {
        if (node == null) return;

        sb.append(padding);
        sb.append(pointer);
        sb.append(node.value);
        sb.append("\n");

        String paddingForBoth = padding + "│  ";
        String pointerForRight = "└──";
        String pointerForLeft = (node.right != null) ? "├──" : "└──";

        traversePreOrder(sb, paddingForBoth, pointerForLeft, node.left);
        traversePreOrder(sb, paddingForBoth, pointerForRight, node.right);
    }

    public TreeNode getNode(int value) {
        return getNode(this, value);
    }

    public TreeNode getNode(TreeNode node, int value) {
        if (node == null) return null;

        if (node.value == value) return node;

        TreeNode leftNode = getNode(node.left, value);
        if (leftNode != null) return leftNode;
        return getNode(node.right, value);
    }
}
