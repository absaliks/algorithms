package absaliks.leetcode;

public class MergeTwoSortedLists {


  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }

    ListNode head;
    if (l1.val <= l2.val) {
      head = l1;
      l1 = l1.next;
    } else {
      head = l2;
      l2 = l2.next;
    }
    ListNode tail = head;
    do {
      if (l1 == null) {
        tail.next = l2;
        break;
      }
      if (l2 == null) {
        tail.next = l1;
        break;
      }
      if (l1.val <= l2.val) {
        tail.next = l1;
        l1 = l1.next;
      } else {
        tail.next = l2;
        l2 = l2.next;
      }
      tail = tail.next;
    } while (true);
    return head;
  }
}

