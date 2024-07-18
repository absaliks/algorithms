package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree
public class LongestZigZagPathInBinaryTreeTest {
    public int longestZigZag(TreeNode root) {
        return longestZigZag(root, 0, 0);
    }

    public int longestZigZag(TreeNode root, int srcDirection, int streak) {
        var leftStreak = root.left != null
                ? longestZigZag(root.left, -1, srcDirection == 1 ? streak + 1 : 1)
                : streak;
        var rightStreak = root.right != null
                ? longestZigZag(root.right, 1, srcDirection == -1 ? streak + 1 : 1)
                : streak;
        return Math.max(leftStreak, rightStreak);
    }

    @Test
    void name() {
        var l6 = tree(6);
        var l5 = tree(5, null, l6);
        var l4a = tree(41, null, l5);
        var l4b = tree(42);
        var l3a = tree(31);
        var l3b = tree(32, l4a, l4b);
        var l2 = tree(2, l3a, l3b);
        var root = tree(1, null, l2);

        assertEquals(3, longestZigZag(root));
    }

    private static TreeNode tree(int root) {
        return new TreeNode(root, null, null);
    }

    private static TreeNode tree(int root, Integer left, Integer right) {
        return new TreeNode(root, TreeNode.of(left), TreeNode.of(right));
    }

    private static TreeNode tree(int root, TreeNode left, TreeNode right) {
        return new TreeNode(root, left, right);
    }
}
