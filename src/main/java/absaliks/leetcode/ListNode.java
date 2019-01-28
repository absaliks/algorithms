package absaliks.leetcode;

public class ListNode {
  public int val;
  public ListNode next;

  public ListNode(int x) {
    val = x;
  }

  @Override
  public String toString() {
    final StringBuilder builder = new StringBuilder(6);
    ListNode node = this;
    do {
      builder.append(node.val);
    } while ((node = node.next) != null);
    return builder.toString();
  }
}
