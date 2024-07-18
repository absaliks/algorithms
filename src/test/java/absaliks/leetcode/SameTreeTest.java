package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/same-tree/
public class SameTreeTest {

  private static boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      return false;
    }
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  private static void assertIsSameTree(boolean expected, TreeNode a, TreeNode b) {
    assertEquals(expected, isSameTree(a, b));
  }

  @Test void test1() {
    assertIsSameTree(true, tree(1, 2, 3), tree(1, 2, 3));
  }

  @Test void test2() {
    assertIsSameTree(false, tree(1, 2, null), tree(1, null, 2));
  }

  @Test void test3() {
    assertIsSameTree(false, tree(1, 2, 1), tree(1, 1, 2));
  }

  private static TreeNode tree(int root, Integer left, Integer right) {
    return new TreeNode(root, TreeNode.of(left), TreeNode.of(right));
  }
}
