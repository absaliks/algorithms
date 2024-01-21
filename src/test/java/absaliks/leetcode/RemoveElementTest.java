package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RemoveElementTest {

  // https://leetcode.com/problems/remove-element
  public int removeElement(int[] nums, int val) {
    int writeCursor = 0;
    for (int i = 0; i < nums.length; i++) {
      int value = nums[i];
      if (value != val)
        nums[writeCursor++] = value;
    }
    return writeCursor;
  }

  @Test
  void test1() {
    int[] nums1 = { 3,2,2,3 };
    int expectedLength = 2;

    int resultLength = removeElement(nums1, 3);

    assertEquals(expectedLength, resultLength);
    assertArrayEquals(
        new int[] { 2, 2 },
        Arrays.copyOf(nums1, resultLength));
  }

  @Test
  void test2() {
    int[] nums1 = { 0, 1, 2, 2, 3, 0, 4, 2 };
    int expectedLength = 5;

    int resultLength = removeElement(nums1, 2);

    assertEquals(expectedLength, resultLength);
    assertArrayEquals(
        new int[] { 0, 1, 3, 0, 4 },
        Arrays.copyOf(nums1, resultLength));
  }
}