package absaliks.leetcode;

public class TreeNode{
    public final int val;
    public final TreeNode left;
    public final TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(Integer value) {
        return value != null ? new TreeNode(value, null, null) : null;
    }

    public static TreeNode of (Integer... values) {
        return TreeNode.of();
    }
}
