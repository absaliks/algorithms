package absaliks.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
          return nums.length;
        }
        short writeCursor = 0;
        int wValue = nums[0];
        for (short readCursor = 1; readCursor < nums.length; readCursor++) {
          final int rValue = nums[readCursor];
          if (wValue < rValue) {
            nums[++writeCursor] = rValue;
            wValue = rValue;
          }
        }
        return writeCursor + 1;
  }
}
