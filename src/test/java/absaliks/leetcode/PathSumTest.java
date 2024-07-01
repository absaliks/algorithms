package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PathSumTest {

    private record TreeNode(int val, TreeNode left, TreeNode right) {

        public static TreeNode of(Integer value) {
            return value != null ? new TreeNode(value, null, null) : null;
        }

        private static TreeNode tree(int root, Integer left, Integer right) {
            return new TreeNode(root, TreeNode.of(left), TreeNode.of(right));
        }
    }

    // https://leetcode.com/problems/path-sum/submissions/1304714559/
    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum == root.val;
        }
        var leafTarget = targetSum - root.val;
        return hasPathSum(root.left, leafTarget) || hasPathSum(root.right, leafTarget);
    }

    @Test
    void name1() {
        assertTrue(hasPathSum(TreeNode.tree(0, 1, null), 1));
    }

    @Test
    void name2() {
        assertFalse(hasPathSum(TreeNode.tree(1, 2, null), 1));
    }
}
