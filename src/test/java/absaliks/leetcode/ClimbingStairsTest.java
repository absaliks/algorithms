package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

// https://leetcode.com/problems/climbing-stairs
public class ClimbingStairsTest {
    public int climbStairs(int n) {
        return 0;
    }

    @ParameterizedTest
    @CsvSource(textBlock = """
            2, 2
            3, 3
            4, 5
            """)
    void test(int given, int expected) {
        /*
        1 1 1 1
        1 2 1
        2 1 1
        1 1 2
        2 2
        */

        assertEquals(expected, climbStairs(given));
    }
}
