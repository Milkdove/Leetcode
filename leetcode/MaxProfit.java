package leetcode;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        Arrays.fill(dp, 0);
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - prices[i - 1] + dp[i - 1]);
        }
        return dp[prices.length - 1];
    }

    @Test
    public void test() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int res = maxProfit(prices);
        System.out.println(res);

    }
}
