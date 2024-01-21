package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class MergeSortedArrayTest {

  // https://leetcode.com/problems/merge-sorted-array
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int index1 = m - 1;
    int index2 = n - 1;
    for (int i = nums1.length - 1; i >= 0; i--) {
      int a = index1 > -1 ? nums1[index1] : Integer.MIN_VALUE;
      int b = index2 > -1 ? nums2[index2] : Integer.MIN_VALUE;
      if (a >= b) {
        nums1[i] = a;
        index1--;
      } else {
        nums1[i] = b;
        index2--;
      }
    }
  }

  @Test
  void name() {
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    int m = 3;
    int[] nums2 = { 2, 5, 6 };
    merge(nums1, m, nums2, nums2.length);

    assertArrayEquals(
        new int[] { 1, 2, 2, 3, 5, 6 },
        nums1);
  }

  @Test
  void name1() {
    int[] nums1 = { 1 };
    int m = 1;
    int[] nums2 = {};
    merge(nums1, m, nums2, nums2.length);

    assertArrayEquals(
        new int[] { 1 },
        nums1);
  }

  @Test
  void name3() {
    int[] nums1 = { 0 };
    int m = 0;
    int[] nums2 = { 1 };
    merge(nums1, m, nums2, nums2.length);

    assertArrayEquals(
        new int[] { 1 },
        nums1);
  }
}