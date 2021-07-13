package leetcode;

import org.junit.Test;

import java.util.List;

/**
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
 */
public class MinimumTotal {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int res = Integer.MAX_VALUE;
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int val = triangle.get(i).get(j);
                dp[i & 1][j] = Integer.MAX_VALUE;
                if (j != 0) dp[i & 1][j] = Math.min(dp[i & 1][j], dp[(i - 1) & 1][j - 1] + val);
                if (j != i) dp[i & 1][j] = Math.min(dp[i & 1][j], dp[(i - 1) & 1][j] + val);
            }
        }
        for (int i = 0; i < n; i++) res = Math.min(res, dp[(n - 1) & 1][i]);
        return res;
    }

    @Test
    public void test() {

    }
}
