package absaliks.leetcode;

/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicatesFromSortedArray {
  public int removeDuplicates(int[] nums) {
    if (nums == null) {
      return 0;
    }
    if (nums.length < 2) {
      return 1;
    }
    int seekingCursor = 2;
    final int maxI = nums.length - 1;
    for (int i = 1; i < maxI; i++) {
      final int nextI = i + 1;
      final int nextValue = nums[nextI];
      if (nums[i] == nextValue) {
        for (int j = nextI; j < nums.length; j++) {

        }
      }
    }
    return 0;
  }
}
