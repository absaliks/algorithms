package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/squares-of-a-sorted-array
public class SquaresOfASortedArrayTest {

    // CPU: beats 100% CPU
    // RAM: beats 11.95%
    public int[] sortedSquares(int... nums) {
        if (nums.length == 1) {
            nums[0] = nums[0] * nums[0];
            return nums;
        }

        int[] result = new int[nums.length];

        // find center (too lazy to do binary search)
        int center = 0;
        while (nums[center] <= 0 && ++center < nums.length);

        int writeCursor = 0;
        int leftCursor = center - 1;
        int rightCursor = center;
        while (leftCursor >= 0 || rightCursor < nums.length) {
            var leftValue = leftCursor >= 0 ? - nums[leftCursor] : Integer.MAX_VALUE;
            var rightValue = rightCursor < nums.length ? nums[rightCursor] : Integer.MAX_VALUE;
            if (leftValue <= rightValue) {
                result[writeCursor++] = leftValue * leftValue;
                leftCursor--;
            } else {
                result[writeCursor++] = rightValue * rightValue;
                rightCursor++;
            }
        }
        return result;
    }

    @Test
    void case1() {
        assertArrayEquals(
                new int[] { 0, 1, 9, 16, 100 },
                sortedSquares(-4, -1, 0, 3, 10));
    }

    @Test
    void case2() {
        assertArrayEquals(
                new int[] { 4, 9, 9, 49, 121 },
                sortedSquares(-7, -3, 2, 3, 11));
    }

    @Test
    void positivesOnly() {
        assertArrayEquals(
                new int[] { 1, 4 },
                sortedSquares(1, 2));
    }

    @Test
    void noNegatives() {
        assertArrayEquals(
                new int[] { 0, 4 },
                sortedSquares(0, 2));
    }

    @Test
    void negativesOnly() {
        assertArrayEquals(
                new int[] { 1, 4 },
                sortedSquares(-2, -1));
    }

    @Test
    void case3p() {
        assertArrayEquals(
                new int[] { 9 },
                sortedSquares(3));
    }

    @Test
    void case3n() {
        assertArrayEquals(
                new int[] { 9 },
                sortedSquares(-3));
    }

    @Test
    void case3z() {
        assertArrayEquals(
                new int[] { 0 },
                sortedSquares(0));
    }
}
