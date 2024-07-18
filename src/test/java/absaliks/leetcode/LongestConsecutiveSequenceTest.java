package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/longest-consecutive-sequence
// CPU 31ms | Beats 52.19%
// RAM 60.87MB | Beats 67.22%
public class LongestConsecutiveSequenceTest {

    public int longestConsecutive(int... nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int result = 0;
        for (int num : nums) {
            int streak = 1;
            for (int left = num - 1; set.remove(left); left--) streak++;
            for (int right = num + 1; set.remove(right); right++) streak++;
            result = Math.max(result, streak);
        }
        return result;
    }

    @Test
    void test0() {
        assertEquals(3, longestConsecutive(1, 3, 2));
    }

    @Test
    void test1() {
        assertEquals(4, longestConsecutive(100, 4, 200, 1, 3, 2));
    }

    @Test
    void test2() {
        assertEquals(9, longestConsecutive(0, 3, 7, 2, 5, 8, 4, 6, 0, 1));
    }
}
