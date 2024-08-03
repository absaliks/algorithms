package absaliks.leetcode;

public class TreeNode {
    public final int val;
    public final TreeNode left;
    public final TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val, int left, int right) {
        this.val = val;
        this.left = new TreeNode(left);
        this.right = new TreeNode(right);
    }
}
