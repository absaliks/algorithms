package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

// https://leetcode.com/problems/jump-game
// med | 20m
public class JumpGameTest {

    public boolean canJump(int... nums) {
        int cursor = 0;
        int reach = 0;
        int lastIndex = nums.length - 1;
        do {
            reach = Math.max(reach - 1, nums[cursor]);
            if (reach >= lastIndex - cursor) {
                return true;
            }
            if (reach == 0) {
                return false;
            }
        } while (++cursor < lastIndex);
        return false;
    }

    public static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(true, new int[] { 0 }),
                Arguments.of(false, new int[] { 0, 2, 3 }),
                Arguments.of(true, new int[] { 2, 3, 1, 1, 4 }),
                Arguments.of(false, new int[] { 3, 2, 1, 0, 4 }),
                Arguments.of(true, new int[] { 1, 0 }),
                Arguments.of(true, new int[] { 2, 0, 0 }),
                Arguments.of(true, new int[] { 1, 1, 0 }));
    }

    @ParameterizedTest
    @MethodSource
    void test(boolean expected, int[] nums) {
        assertEquals(expected, canJump(nums));
    }
}
