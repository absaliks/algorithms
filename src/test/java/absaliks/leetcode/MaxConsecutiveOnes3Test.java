package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// Max Consecutive Ones III
// https://leetcode.com/problems/max-consecutive-ones-iii
// Runtime 114ms | Beats 5.60%
// RAM 46.80MB | Beats 23.04%
public class MaxConsecutiveOnes3Test {
    public static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        boolean lastValue = false;
        for (int i = 0; i < nums.length; i++) {
            boolean value = nums[i] == 1;
            if (value && !lastValue) {
                maxLen = Math.max(maxLen, len(nums, k, i));
            }
            lastValue = value;
        }
        return maxLen != 0 ? maxLen
                : len(nums, k, nums.length - 1);
    }

    private static int len(int[] nums, int flips, int startIndex) {
        int length = 0;
        for (int i = startIndex; i < nums.length && (nums[i] == 1 || flips-- > 0); i++)
            length++;
        for (int i = startIndex - 1; i >= 0 && flips-- > 0 && nums[i] == 0; i--)
            length++;
        return length;
    }

    @Test
    void example1() {
        assertEquals(6, longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
    }

    @Test
    void example2() {
        assertEquals(10, longestOnes(new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 }, 3));
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(1, new int[] { 0 }, 1),
                Arguments.of(1, new int[] { 1 }, 0),
                Arguments.of(1, new int[] { 1 }, 10),
                Arguments.of(1, new int[] { 1, 0, 1 }, 0),
                Arguments.of(3, new int[] { 1, 1, 1 }, 3),
                Arguments.of(3, new int[] { 1, 1, 1 }, 0)
        );
    }

    @ParameterizedTest
    @MethodSource
    void test(int expected, int[] nums, int flips) {
        assertEquals(expected, longestOnes(nums, flips));
    }
}
