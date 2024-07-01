package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/build-array-from-permutation/
public class BuildArrayFromPermutationTest {

    // Gave up, looked at the answers - it didn't even occur to me that extra data can be stored using multipliers and
    // stuff. It was somewhat useful experience, but I was too angry at the author to appreciate it - it's definitely
    // should not be "easy".
    // ---
    // This solution should not be acceptable, as problem description contains it, applying it nevertheless so that
    // I didn't attempt to solve (waste time on) it again
    public static int[] buildArray(int... nums) {
        var result = new int[nums.length];
        for (int i = 0; i < nums.length; i++)
            result[i] = nums[nums[i]];
        return result;
    }

    @Test
    void case1() {
        assertArrayEquals(
                new int[] { 0, 1, 2, 4, 5, 3 },
                buildArray(0, 2, 1, 5, 3, 4));
    }

    @Test
    void case2() {
        assertArrayEquals(
                new int[] { 4, 5, 0, 1, 2, 3 },
                buildArray(5, 0, 1, 2, 3, 4));
    }

    private static int[] array(int... i) {
        return i;
    }
}
