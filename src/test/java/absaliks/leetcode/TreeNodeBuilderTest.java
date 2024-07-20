package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TreeNodeBuilderTest {
    public TreeNode tree(Integer... values) {
        return null;
    }

    @Test
    /* SRC: https://support.leetcode.com/hc/en-us/articles/360011883654-What-does-1-null-2-3-mean-in-binary-tree-representation

          5
        /   \
       1     4
            / \
           3   6
    */
    void test1() {
        var l3a = tree(3);
        var l3b = tree(6);
        var l2a = tree(1);
        var l2b = tree(4, l3a, l3b);
        var root = tree(5, l2a, l2b);

        assertEquals(root, tree(5, 1, 4, null, null, 3, 6));
    }

    @Test
    /* SRC: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/description/
        1
         \
          2
        /   \
      31     32
            /  \
          41    42
            \
             5
              \
               6
    */
    void longestZigZagTree() {
        var l6 = tree(6);
        var l5 = tree(5, null, l6);
        var l4a = tree(41, null, l5);
        var l4b = tree(42);
        var l3a = tree(31);
        var l3b = tree(32, l4a, l4b);
        var l2 = tree(2, l3a, l3b);
        var root = tree(1, null, l2);

        assertEquals(root, tree());
    }

    private static TreeNode tree(int root) {
        return new TreeNode(root);
    }

    private static TreeNode tree(int root, Integer left, Integer right) {
        return new TreeNode(root, new TreeNode(left), new TreeNode(right));
    }

    private static TreeNode tree(int root, TreeNode left, TreeNode right) {
        return new TreeNode(root, left, right);
    }
}
