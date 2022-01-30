package binarytree;

public class TreeNode {

    private TreeNode left;
    private TreeNode right;
    private final int value;

    TreeNode(int value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return this.left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return this.right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getValue() {
        return this.value;
    }
}
