package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// Trapping Rain Water
// https://leetcode.com/problems/trapping-rain-water
public class TrappingRainWaterTest {

    public int trap(int... height) {
        int maxElevation = 0;
        int maxElevationIndex = 0;
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            if (maxElevation < h) {
                maxElevation = h;
                maxElevationIndex = i;
            }
        }


        int waterAmount = 0;
        int wellIndex = 0;
        for (int cursor = 0; cursor <= maxElevationIndex; cursor++) {
            int wellElevation = height[wellIndex];
            int currentHeight = height[cursor];

            if (wellElevation > currentHeight) {
                waterAmount += wellElevation - currentHeight;
            } else {
                wellIndex = cursor;
            }
        }

        wellIndex = height.length - 1;
        for (int cursor = height.length - 2; cursor >= maxElevationIndex; cursor--) {
            int wellElevation = height[wellIndex];
            int currentHeight = height[cursor];

            if (wellElevation > currentHeight) {
                waterAmount += wellElevation - currentHeight;
            } else {
                wellIndex = cursor;
            }
        }
        return waterAmount;
    }

    @Test
    void caseX() {
        assertEquals(5, trap(10, 0, 5));
    }

    @Test
    void case1() {
        assertEquals(6, trap(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1));
    }

    @Test
    void case2() {
        assertEquals(9, trap(4, 2, 0, 3, 2, 5));
    }
}
