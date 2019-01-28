package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class MergeTwoSortedListsTest {

  private MergeTwoSortedLists solution = new MergeTwoSortedLists();

  @Test
  void mergeListWithNull() {
    ListNode list = createList(new int[]{1, 7, 9});
    assertEquals("179", solution.mergeTwoLists(null, list).toString());
  }

  @Test
  void mergeTwoLists() {
    ListNode list1 = createList(new int[]{1, 2, 4});
    ListNode list2 = createList(new int[]{1, 3, 4});
    assertEquals("112344", solution.mergeTwoLists(list1, list2).toString());
  }

  private ListNode createList(int[] items) {
    ListNode result = null;
    ListNode lastNode = null;
    for (int item : items) {
      ListNode node = new ListNode(item);
      if (lastNode != null) {
        lastNode.next = node;
      } else {
        result = node;
      }
      lastNode = node;
    }
    return result;
  }

  @Test
  void testCreateList() {
    assertEquals("112344", createList(new int[] {1, 1, 2, 3, 4, 4}).toString());
  }
}