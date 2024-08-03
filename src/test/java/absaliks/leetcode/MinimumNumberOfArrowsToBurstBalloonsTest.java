package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import absaliks.Utils;

// Minimum Number of Arrows to Burst Balloons
// https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
public class MinimumNumberOfArrowsToBurstBalloonsTest {

    // 40m + 14:03
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int arrowPos = points[0][1];
        int arrowCnt = 1;
        for (int i = 1; i < points.length; i++) {
            if (arrowPos >= points[i][0]) {
                continue;
            }
            arrowCnt++;
            arrowPos = points[i][1];
        }
        return arrowCnt;
    }


    @Test
    void triggerHappyConsequence_falseBait() {
        // |12345|
        // |  == |  — both x=3 and x=4 result in 2 balloons popped, however if you choose the first available X, then
        // |==   |  the second and third balloons are going to be left separated, requiring 3 shots in total.
        // |   ==|
        // | ==  |
        // | x x |  — the correct strategy is 2 + 4

        var pts = points(3,4, 1,3, 4,5, 2,3);
        assertEquals(2, findMinArrowShots(pts));
    }

    private static boolean isIn(int i, int[] interval) {
        return interval[0] <= i && i <= interval[1];
    }

    // ----- TEST ------

    private static int len(int[] interval) {
        return interval[1] - interval[0];
    }

    private static int[][] points(int... xes) {
        return (int[][]) Utils.groupElements(2, xes);
    }


    @Test
    void triggerHappyConsequence_equalLethality() {
        var pts = points(3,4, 1,2, 4,5, 2,3);
        assertEquals(2, findMinArrowShots(pts));
    }



    static Stream<Arguments> test() {
        return Stream.of(
                Arguments.of(1, points(1,5, 3,6)),
                Arguments.of(3, points(1,2, 3,3, 4,5)),
                Arguments.of(1, points(1,2147483647)),
                Arguments.of(2, points(-2147483646,-2147483645, 2147483646,2147483647)),
                Arguments.of(3,  points(2,3, 7,15, 5,12, 4,5, 8,13, 9,16, 5,8, 8,16, 3,4, 8,17)),
                // ----------
                Arguments.of(2, points(10,16, 2,8, 1,6, 7,12)),
                Arguments.of(4, points(1,2, 3,4, 5,6, 7,8)),
                Arguments.of(2, points(1,2, 2,3, 3,4, 4,5)));
    }

    @ParameterizedTest
    @MethodSource
    void test(int expected, int[][] given) {
        assertEquals(expected, findMinArrowShots(given));
    }
}
