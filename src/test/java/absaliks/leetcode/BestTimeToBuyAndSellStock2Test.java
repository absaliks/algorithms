package absaliks.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
public class BestTimeToBuyAndSellStock2Test {
    public static int maxProfit(int... prices) {
        int profit = 0;
        for (int day = 0; day < prices.length - 1; day++) {
            int today = prices[day];
            int tomorrow = prices[day + 1];
            if (today < tomorrow) {
                profit += tomorrow - today;
            }
        }
        return profit;
    }

    @Test
    void case1() {
        assertEquals(7, maxProfit(7, 1, 5, 3, 6, 4));
    }

    @Test
    void case2() {
        assertEquals(4, maxProfit(1, 2, 3, 4, 5));
    }

    @Test
    void case3() {
        assertEquals(0, maxProfit(7, 6, 4, 3, 1));
    }
}
